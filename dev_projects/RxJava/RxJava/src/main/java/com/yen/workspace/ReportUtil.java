package com.yen.workspace;

import com.yen.workspace.model.Report;
import com.yen.workspace.model.TestResult;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportUtil {

  public static List<Report> getReports() {

    TestResult t1 = new TestResult(1, "s1", "ok", java.util.Date.from(Instant.now()));
    TestResult t2 = new TestResult(2, "s2", "pending", java.util.Date.from(Instant.now()));
    TestResult t3 = new TestResult(3, "s3", "failed", java.util.Date.from(Instant.now()));

    TestResult t4 = new TestResult(4, "s1", "ok", java.util.Date.from(Instant.now()));
    TestResult t5 = new TestResult(5, "s2", "pending", java.util.Date.from(Instant.now()));

    List<TestResult> list1 = Arrays.asList(t1,t2,t3);
    List<TestResult> list2 = Arrays.asList(t4,t5);

    Report r1 = new Report(1, list1);
    Report r2 = new Report(2, list2);

    List<Report> reports = Arrays.asList(r1, r2);
    return reports;
  }

  public static List<TestResult> getTestResults() {
    /**
     * private Integer id; private String serialNum; private String status; private Date createTime;
     */
    TestResult t1 = new TestResult(1, "s1", "ok", java.util.Date.from(Instant.now()));
    TestResult t2 = new TestResult(2, "s2", "pending", java.util.Date.from(Instant.now()));
    TestResult t3 = new TestResult(3, "s3", "failed", java.util.Date.from(Instant.now()));
    List<TestResult> list = Arrays.asList(t1,t2,t3);
    return list;
  }

}
