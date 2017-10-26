package com.samebug.demo.crashtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import org.mongojack.JacksonDBCollection;

import javax.inject.Inject;
import java.util.List;


public class ErrorReportDao {
    private JacksonDBCollection<ErrorReport, String> collection;

    @Inject
    public ErrorReportDao(DB db, ObjectMapper mapper) {
        this.collection =
                JacksonDBCollection.wrap(
                        db.getCollection("errors_reports"),
                        ErrorReport.class, String.class,
                        mapper);
    }

    ErrorReport insert(ErrorReport report) {
        return collection.insert(report).getSavedObject();
    }

    List<ErrorReport> insert(List<ErrorReport> reports) {
        return collection.insert(reports).getSavedObjects();
    }
}
