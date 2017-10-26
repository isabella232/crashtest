package com.samebug.demo.crashtest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.mongojack.internal.ObjectIdDeserializers;
import org.mongojack.internal.ObjectIdSerializer;

class ErrorReport {
    @JsonSerialize(using = ObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdDeserializers.ToStringDeserializer.class)
    @JsonProperty("_id")
    private String id;
    private User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stacktrace;

    public ErrorReport() {
    }

    public ErrorReport(String id, User user, String stacktrace) {
        this.id = id;
        this.user = user;
        this.stacktrace = stacktrace;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }
}

