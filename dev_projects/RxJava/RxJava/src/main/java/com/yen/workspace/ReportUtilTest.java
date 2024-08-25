package com.yen.workspace;

import com.yen.workspace.model.Report;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    List<String> statusList = ReportUtil.getTestResultByserialNum("s1").stream().flatMap(
            x -> {
              String status = x.getStatus();
              return Stream.of(status);
            }
    ).collect(Collectors.toList());

    System.out.println("statusList = " + statusList);

    System.out.println("==================");

    System.out.println(ReportUtil.getTestResultByserialNum("s2"));

    System.out.println("==================");

    System.out.println(ReportUtil.getTestResultByserialNum("some_num"));
  }
}
