package com.samebug.demo.crashtest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.samebug.demo.crashtest.module.TestModule;
import junit.framework.TestCase;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ErrorReportDaoTest extends TestCase {

    private Injector injector = Guice.createInjector(new TestModule());
    private ErrorReportDao dao = injector.getInstance(ErrorReportDao.class);
    private UserService userService = injector.getInstance(UserService.class);

    public void testInsert() throws IOException {
        Map<String, List<String>> allTraces = readErrorReports("/error-reports.zip");
        allTraces.forEach((dir, traces) -> {
            List<ErrorReport> reports = traces.stream().map(t ->
                    new ErrorReport(null, userService.getUser(2L), t)).collect(Collectors.toList());
            List<ErrorReport> inserted = dao.insert(reports);
            assertEquals(inserted.size(), reports.size());
        });
    }

    private Map<String, List<String>> readErrorReports(String name) throws IOException {
        Map<String, List<String>> reports = new TreeMap<String, List<String>>();
        InputStream is = System.class.getResourceAsStream(name);
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            String dirName = ze.getName().split("/")[0];
            if (ze.isDirectory()) {
                reports.put(dirName, new LinkedList<String>());
            } else {
                int length = (int) ze.getSize();
                byte[] buf = new byte[length];
                zis.read(buf, 0, length);
                reports.get(dirName).add(new String(buf));
            }
        }
        zis.close();
        return reports;
    }
}