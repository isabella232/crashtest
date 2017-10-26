package com.samebug.demo.crashtest;

import com.fasterxml.jackson.annotation.JsonInclude;

public class User {
    private Long id;
    private String displayName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String avatarUrl;

    public User(Long id, String displayName, String avatarUrl) {
        this.id = id;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
