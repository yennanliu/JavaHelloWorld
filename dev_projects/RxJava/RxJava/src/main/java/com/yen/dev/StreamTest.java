package com.yen.dev;

import com.yen.workspace.ReportUtil;
import com.yen.workspace.model.Report;
import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  https://blog.csdn.net/xiaofeng10330111/article/details/130457788
 *  https://blog.csdn.net/netyeaxi/article/details/103757510
 */

public class StreamTest {

    @Test
    public void test1() {

        // from workspace
        List<Report> reports = ReportUtil.getReports();
    reports.stream()
        .flatMap(
            report -> {

              // >>> stream = java.util.stream.ReferencePipeline$Head@5b94b04d
              System.out.println(">>> stream = " + report.getResults().stream());

              // >>> stream str = java.util.stream.ReferencePipeline$Head@8c3b9d
              System.out.println(">>> stream str = " + report.getResults().stream().toString());

              // >>> stream array = [Ljava.lang.Object;@e4487af
              System.out.println(">>> stream array = " + report.getResults().stream().toArray());

              // >>> stream first = Optional[TestResult{id=4, serialNum='s1', status='ok', createTime=Sat Aug 24 17:31:52 CST 2024}]
              System.out.println(">>> stream first = " + report.getResults().stream().findFirst().toString());

              return report.getResults().stream();
            })
        .collect(Collectors.toList());
    }

}
