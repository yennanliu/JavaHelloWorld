package org.example.AnnotationAop;

// https://youtu.be/WjEWMZlpiRo?si=SvBt-qofCgjDdncI&t=1095

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(1,2);
    }

}
