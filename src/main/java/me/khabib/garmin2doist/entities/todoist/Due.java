package me.khabib.garmin2doist.entities.todoist;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "recurring",
        "string",
        "date"
})
class Due {

    @JsonProperty("recurring")
    private Boolean recurring;
    @JsonProperty("string")
    private String string;
    @JsonProperty("date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("recurring")
    public Boolean getRecurring() {
        return recurring;
    }

    @JsonProperty("recurring")
    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    @JsonProperty("string")
    public String getString() {
        return string;
    }

    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
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
