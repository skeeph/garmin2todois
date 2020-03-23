package me.khabib.garmin2doist.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskNote {
    Long itemId;
    String content;

    @JsonProperty("item_id")
    public Long getItemId() {
        return itemId;
    }

    public TaskNote setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TaskNote setContent(String content) {
        this.content = content;
        return this;
    }
}
