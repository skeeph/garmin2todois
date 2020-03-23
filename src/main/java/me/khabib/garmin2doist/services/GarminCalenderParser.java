package me.khabib.garmin2doist.services;

import me.khabib.garmin2doist.entities.Event;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Content;
import net.fortuna.ical4j.model.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GarminCalenderParser {

    private static DateTimeFormatter LOCAL_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static DateTimeFormatter LOCAL_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");


    @Value("${garmin_url}")
    private String garminUrl;


    private Calendar buildCalendar(InputStream in) {
        CalendarBuilder builder = new CalendarBuilder();
        try {
            return builder.build(in);
        } catch (IOException | ParserException e) {
            throw new RuntimeException(e);
        }
    }

    private Mono<Calendar> downloadIcs() {
        return WebClient.create(garminUrl).get()
                .retrieve()
                .bodyToMono(byte[].class)
                .map(ByteArrayInputStream::new)
                .map(this::buildCalendar);
    }

    public Flux<Event> getEvents() {
        return downloadIcs().
                flatMapMany(x -> Flux.fromIterable(x.getComponents()))
                .filter(x -> x.getName().equals("VEVENT"))
                .map(calendarComponent -> calendarComponent.getProperties().stream()
                        .collect(Collectors.toMap(Property::getName, Content::getValue)))
                .map(this::parseEvent)
                .filter(event -> !event.getSummary().equals("Rest"))
                .filter(event -> !event.getSummary().contains("Cross"));
    }

    private Event parseEvent(Map<String, String> source) {
        final LocalDate date = LocalDate.parse(source.get("DTSTART"), LOCAL_DATE_FORMAT);
        final LocalDateTime time = LocalDateTime.parse(source.get("DTSTAMP"), LOCAL_DATE_TIME_FORMAT);
        return new Event()
                .setId(source.get("UID"))
                .setSummary(source.get("SUMMARY"))
                .setDescription(source.get("DESCRIPTION"))
                .setDate(date).setTime(time);
    }
}
