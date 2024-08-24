package com.yen.workspace;

import com.yen.workspace.model.Report;
import com.yen.workspace.model.TestResult;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportUtil {

  public static List<Report> getReports() {
    return null;
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
