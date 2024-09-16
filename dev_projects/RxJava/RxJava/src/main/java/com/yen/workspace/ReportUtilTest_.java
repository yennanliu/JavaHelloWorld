package com.yen.workspace;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportUtilTest_ {
  public static void main(String[] args) {

    //    System.out.println(ReportUtil.getTestResults());
    //
    //    System.out.println("==================");
    //
    //    System.out.println(ReportUtil.getReports());

    // System.out.println("==================");
    System.out.println(ReportUtil.getTestResultBySerialNum("s1"));

    System.out.println("==================");

    List<String> statusList =
        ReportUtil.getTestResultBySerialNum("s1").stream()
            .flatMap(
                x -> {
                  String status = x.getStatus();
                  return Stream.of(status);
                })
            .collect(Collectors.toList());

    System.out.println("statusList = " + statusList);

    System.out.println("==================");

    System.out.println(ReportUtil.getTestResultBySerialNum("s2"));

    System.out.println("==================");

    System.out.println(ReportUtil.getTestResultBySerialNum("some_num"));
  }
}
