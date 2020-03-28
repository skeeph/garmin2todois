package me.khabib.garmin2doist.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class TaskNote {
    Long itemId;
    String content;

    @JsonProperty("item_id")
    public Long getItemId() {
        return itemId;
    }

    public String getContent() {
        return content;
    }
}
