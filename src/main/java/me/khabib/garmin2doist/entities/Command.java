package me.khabib.garmin2doist.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Command {
    Object args;
    String token;
    String type;
    String tempId;
    String uuid;

    public Object getArgs() {
        return args;
    }

    public Command setArgs(Object args) {
        this.args = args;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Command setToken(String token) {
        this.token = token;
        return this;
    }

    public String getType() {
        return type;
    }

    public Command setType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("temp_id")
    public String getTempId() {
        return tempId;
    }

    public Command setTempId(String tempId) {
        this.tempId = tempId;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Command setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }
}
