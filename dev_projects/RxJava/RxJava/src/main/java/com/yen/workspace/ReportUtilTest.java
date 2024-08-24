package com.yen.workspace;

import com.yen.workspace.model.Report;

public class ReportUtilTest {
  public static void main(String[] args) {

//    System.out.println(ReportUtil.getTestResults());
//
//    System.out.println("==================");
//
//    System.out.println(ReportUtil.getReports());

    //System.out.println("==================");
    System.out.println(ReportUtil.getTestResultByserialNum("s1"));

    System.out.println("==================");

    System.out.println(ReportUtil.getTestResultByserialNum("some_num"));
  }
}
