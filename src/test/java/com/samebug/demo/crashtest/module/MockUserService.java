package com.samebug.demo.crashtest.module;

import com.samebug.demo.crashtest.User;
import com.samebug.demo.crashtest.UserService;

public class MockUserService implements UserService {
    public User getUser(Long id) {
        return new User(id, String.format("mock user %d", id), null);
    }
}
