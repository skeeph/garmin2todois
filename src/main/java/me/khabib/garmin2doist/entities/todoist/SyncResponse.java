package me.khabib.garmin2doist.entities.todoist;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sync_token",
        "temp_id_mapping",
        "full_sync",
        "items"
})
public class SyncResponse {

    @JsonProperty("sync_token")
    private String syncToken;
    @JsonProperty("temp_id_mapping")
    private Map<String, Object> tempIdMapping;
    @JsonProperty("full_sync")
    private boolean fullSync;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sync_token")
    public String getSyncToken() {
        return syncToken;
    }

    @JsonProperty("sync_token")
    public void setSyncToken(String syncToken) {
        this.syncToken = syncToken;
    }

    @JsonProperty("temp_id_mapping")
    public Map<String, Object> getTempIdMapping() {
        return tempIdMapping;
    }

    @JsonProperty("temp_id_mapping")
    public void setTempIdMapping(Map<String, Object> tempIdMapping) {
        this.tempIdMapping = tempIdMapping;
    }

    @JsonProperty("full_sync")
    public boolean isFullSync() {
        return fullSync;
    }

    @JsonProperty("full_sync")
    public void setFullSync(boolean fullSync) {
        this.fullSync = fullSync;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
