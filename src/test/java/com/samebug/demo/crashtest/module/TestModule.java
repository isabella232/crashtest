package com.samebug.demo.crashtest.module;

import com.google.inject.AbstractModule;
import com.samebug.demo.crashtest.UserService;

public class TestModule extends AbstractModule {
    protected void configure() {
        install(new CrashTestModule());
        bind(UserService.class).to(MockUserService.class);
    }
}
