package me.khabib.garmin2doist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoistTask {
    String content;
    String dueDate;
    String description;
    Long project;

    public String getContent() {
        return content;
    }

    public TodoistTask setContent(String content) {
        this.content = content;
        return this;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    public TodoistTask setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public TodoistTask setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("project_id")
    public Long getProject() {
        return project;
    }

    public TodoistTask setProject(Long project) {
        this.project = project;
        return this;
    }

    @Override
    public String toString() {
        return "TodoistTask{" +
                "content='" + content + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                '}';
    }
}
