package com.samebug.demo.crashtest.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class CrashTestModule extends AbstractModule {
  private MongoClient client = new MongoClient("35.185.50.67", 27017);
  private DB database = client.getDB("test");

  private ObjectMapper mapper = new ObjectMapper();

  protected void configure() {
    bind(DB.class).toInstance(database);
    bind(ObjectMapper.class).toInstance(mapper);
  }
}
