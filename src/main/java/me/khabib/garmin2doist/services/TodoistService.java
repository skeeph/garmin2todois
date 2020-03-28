package me.khabib.garmin2doist.services;

import me.khabib.garmin2doist.entities.TaskNote;
import me.khabib.garmin2doist.entities.TodoistTask;
import me.khabib.garmin2doist.entities.todoist.Command;
import me.khabib.garmin2doist.entities.todoist.Commands;
import me.khabib.garmin2doist.entities.todoist.Item;
import me.khabib.garmin2doist.entities.todoist.SavedTask;
import me.khabib.garmin2doist.entities.todoist.SyncQuery;
import me.khabib.garmin2doist.entities.todoist.SyncResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoistService {
    private static final Logger log = LoggerFactory.getLogger(TodoistService.class);

    private static final String TASK_URL = "https://api.todoist.com/rest/v1/tasks";
    private static final String SYNC_URL = "https://api.todoist.com/sync/v8/sync";

    @Value("${doist_oauth}")
    private String token;


    public Mono<Set<String>> getSavedTasks() {
        log.info("Получение задач из Todoist");
        SyncQuery query = new SyncQuery(token, Collections.singletonList("items"));

        return getWebClient(SYNC_URL).body(BodyInserters.fromValue(query))
                .exchange()
                .flatMap(x -> x.bodyToMono(SyncResponse.class))
                .map(x -> x.getItems().stream().map(Item::getContent).collect(Collectors.toSet()));
    }

    protected void addTask(TodoistTask task) {
        log.info("Сохранение задачи в Todost: {}", task);
        getWebClient(TASK_URL)
                .body(BodyInserters.fromValue(task))
                .exchange()
                .flatMap(x -> x.bodyToMono(SavedTask.class))
                .subscribe(
                        savedTask -> addDescription(task, savedTask)
                );

    }

    private WebClient.RequestBodySpec getWebClient(String apiUrl) {
        log.debug("Создание webclient");
        return WebClient.create(apiUrl).post()
                .header("Content-Type", "application/json")
                .header("X-Request-Id", getRandomUUID())
                .header("Authorization", "Bearer " + token);
    }

    private void addDescription(TodoistTask task, SavedTask savedTask) {
        if (StringUtils.isEmpty(task.getDescription())) return;
        log.info("Добавление описания {} к задаче {}", task.getDescription(), task.getContent());
        TaskNote taskNote = new TaskNote(savedTask.getId(), task.getDescription());
        Command command = new Command(taskNote, getRandomUUID(), getRandomUUID(), "note_add");
        Commands commands = new Commands(token, Collections.singletonList(command));
        getWebClient(SYNC_URL)
                .body(BodyInserters.fromValue(commands))
                .exchange()
                .flatMap(x -> x.bodyToMono(String.class))
                .subscribe();

    }

    private String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
