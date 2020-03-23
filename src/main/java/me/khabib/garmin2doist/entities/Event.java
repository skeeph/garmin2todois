package me.khabib.garmin2doist.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {
    String id;
    String summary;
    String description;
    LocalDate date;
    LocalDateTime time;

    public String getId() {
        return id;
    }

    public Event setId(String id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Event setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Event setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Event setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
