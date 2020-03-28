package me.khabib.garmin2doist.converters;

import me.khabib.garmin2doist.entities.Event;
import me.khabib.garmin2doist.entities.TodoistTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class EventToTaskConverter {
    @Value("${doist_project}")
    private String project;

    public TodoistTask convert(Event event) {
        return new TodoistTask()
                .setContent(event.getSummary())
                .setDueDate(event.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .setDescription(event.getDescription())
                .setProject(Long.parseLong(project));
    }

}
