package me.khabib.garmin2doist.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.khabib.garmin2doist.entities.Command;
import me.khabib.garmin2doist.entities.Event;
import me.khabib.garmin2doist.entities.SavedTask;
import me.khabib.garmin2doist.entities.TaskNote;
import me.khabib.garmin2doist.entities.TodoistTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TodoistService {
    //TODO 23.03.2020 murtuzaaliev: 1. Не сохранять дубликаты
    //TODO 23.03.2020 murtuzaaliev: 2. Сохранение заметок

    private static final String TASK_URL = "https://api.todoist.com/rest/v1/tasks";
    private static final String SYNC_URL = "https://api.todoist.com/sync/v8/sync";
    private final GarminCalenderParser garminCalenderParser;
    ObjectMapper mapper = new ObjectMapper();

    @Value("${doist_oauth}")
    private String token;

    @Value("${doist_project}")
    private String project;


    public TodoistService(GarminCalenderParser garminCalenderParser) {
        this.garminCalenderParser = garminCalenderParser;
    }


    private TodoistTask convert(Event event) {
        return new TodoistTask()
                .setContent(event.getSummary())
                .setDueDate(event.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .setDescription(event.getDescription())
                .setProject(Long.parseLong(project));
    }

    @PostConstruct
    public void init() {
        garminCalenderParser.getEvents().map(this::convert).subscribe(this::addTask);
    }

    private void addTask(TodoistTask task) {
        getWebClient(TASK_URL)
                .body(BodyInserters.fromValue(task))
                .exchange()
                .flatMap(x -> x.bodyToMono(SavedTask.class))
                .subscribe(
//                        savedTask -> addDescription(task, savedTask)
                );

    }

    private SavedTask parseSaved(String content) {
        try {
            return mapper.readValue(content, SavedTask.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private WebClient.RequestBodySpec getWebClient(String apiUrl) {
        return WebClient.create(apiUrl).post()
                .header("Content-Type", "application/json")
                .header("X-Request-Id", UUID.randomUUID().toString())
                .header("Authorization", "Bearer " + token);
    }

    //TODO 23.03.2020 murtuzaaliev: Это нерабочая функция не сохраняет заметки
    private void addDescription(TodoistTask task, SavedTask savedTask) {
        TaskNote taskNote = new TaskNote().setItemId(savedTask.getId()).setContent(task.getDescription());
        Command command = new Command()
                .setArgs(taskNote)
                .setToken(token)
                .setUuid(UUID.randomUUID().toString())
                .setTempId(UUID.randomUUID().toString())
                .setType("note_add");
        getWebClient(SYNC_URL)
                .body(BodyInserters.fromValue(command))
                .exchange()
                .flatMap(x -> x.bodyToMono(String.class))
                .subscribe();

    }
}
