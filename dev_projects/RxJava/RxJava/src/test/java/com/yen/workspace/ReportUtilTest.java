package com.yen.workspace;

import com.yen.workspace.model.TestResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportUtilTest {

//    @Test
//    public void test1(){
//        System.out.println(123);
//    }

    @Test
    public void testReturnReportWhenSerialNumExisted(){

        List<TestResult> res = ReportUtil.getTestResultBySerialNum("s1");
        assertEquals(res.size(), 2);
    }

    @Test
    public void testReturnNullWhenSerialNumNotExisted(){

        List<TestResult> res = ReportUtil.getTestResultBySerialNum("some_serial_num");
        assertEquals(res.size(), 0);
    }

}
