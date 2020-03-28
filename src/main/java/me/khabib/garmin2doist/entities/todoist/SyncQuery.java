package me.khabib.garmin2doist.entities.todoist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SyncQuery {
    String token;
    List<String> resourceTypes;

    public String getToken() {
        return token;
    }

    @JsonProperty("sync_token")
    public String getSyncToken() {
        return "*";
    }

    @JsonProperty("resource_types")
    public List<String> getResourceTypes() {
        return resourceTypes;
    }
}
