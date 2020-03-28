package me.khabib.garmin2doist.services;

import me.khabib.garmin2doist.converters.EventToTaskConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private static final Logger log = LoggerFactory.getLogger(MainService.class);
    private static final long SECOND_IN_DAY = 3600 * 24 * 1000;
    private final GarminCalenderParser garminCalenderParser;
    private final TodoistService todoistService;
    private final EventToTaskConverter converter;

    @Autowired
    public MainService(GarminCalenderParser garminCalenderParser, TodoistService todoistService, EventToTaskConverter converter) {
        this.garminCalenderParser = garminCalenderParser;
        this.todoistService = todoistService;
        this.converter = converter;
    }

    @Scheduled(fixedRate = SECOND_IN_DAY)
    public void synchronize() {
        log.info("Запуск синхронизации");
        todoistService.getSavedTasks().subscribe(
                tasks -> garminCalenderParser.getEvents()
                        .filter(event -> !tasks.contains(event.getSummary()))
                        .map(converter::convert)
                        .subscribe(todoistService::addTask)

        );
    }
}
