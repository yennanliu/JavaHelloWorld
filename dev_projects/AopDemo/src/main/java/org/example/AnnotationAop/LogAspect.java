package org.example.AnnotationAop;

// https://youtu.be/WjEWMZlpiRo?si=LaSyN_gqeoOYean0&t=132
// https://youtu.be/ishWB-NpDWo?si=1VgP9aKA3pxa_jvx

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/** class for AOP */
@Component // IOC, make this class managed by spring boot container
@Aspect // aspect class
public class LogAspect {

  // define 1) entry point and 2) notification
  /**
   * 2) notification type:
   *    前置 @Before(value="切入點表達式")
   *    返回 @AfterReturning
   *    異常 @AfterThrowing
   *    後置 @After
   *    環繞 @Around
   *
   *
   *    NOTE: 切入點表達式
   *    // https://youtu.be/WjEWMZlpiRo?si=GUKHpvjt96v0IRIk&t=624
   *
   *    -> execution(訪問修飾符 返回類型 類全路徑.方法名稱  方法參數)
   */

  // `*` means wild card, match all cases
  // @Before(value = "execution(* org.example.AnnotationAop.*.*(..))")
  @Before(value = "execution(public int org.example.AnnotationAop.CalculatorImpl.*(..))")
  public void beforeMethod(){
      System.out.println("[Logging] beforeMethod (前置通知) start");
  }

    @After(value = "execution(* org.example.AnnotationAop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
    System.out.println(
        "[Logging] afterMethod (後置通知) start, 方法名: " + methodName + ", 參數 = " + Arrays.toString(args));
    }

    /** NOTE !!!
     *
     *  AfterReturning 可以回傳返回值
     *
     *   1) put `returning = "result"` in annotation
     *   2) param name need to be same
     *      e.g. Object result
     */
    @AfterReturning(value = "execution(* org.example.AnnotationAop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(
                "[Logging] afterMethod (返回通知) start, 方法名: " + methodName + ", 參數 = " + Arrays.toString(args) + ", 結果 = " + result);
    }

}
