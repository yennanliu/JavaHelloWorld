package com.yen.workspace;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.yen.workspace.model.TestResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class ReportUtilTest {

    @Test
    public void testReturnReportWhenSerialNumExisted(){

        List<TestResult> res = ReportUtil.getTestResultBySerialNum("s1");
        List<String> statsList = res.stream().flatMap(report -> Stream.of(report.getStatus())).collect(Collectors.toList());
        List<String> serialNumList = res.stream().flatMap(report -> Stream.of(report.getSerialNum())).collect(Collectors.toList());

        assertEquals(res.size(), 2);
        assertEquals(statsList, Arrays.asList("ok", "ok"));
        assertEquals(serialNumList, Arrays.asList("s1", "s1"));
    }

    @Test
    public void testReturnNullWhenSerialNumNotExisted(){

        List<TestResult> res = ReportUtil.getTestResultBySerialNum("some_serial_num");
        assertEquals(res.size(), 0);
        assertEquals(res, Arrays.asList());
    }

}
