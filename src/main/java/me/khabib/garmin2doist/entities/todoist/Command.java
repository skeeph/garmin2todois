package me.khabib.garmin2doist.entities.todoist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Command {
    Object args;
    String type;
    String tempId;
    String uuid;

    @JsonProperty("temp_id")
    public String getTempId() {
        return tempId;
    }
}
