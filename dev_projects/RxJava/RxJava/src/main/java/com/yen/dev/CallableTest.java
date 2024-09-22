package com.yen.dev;

import static reactor.core.publisher.Mono.fromCallable;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class CallableTest {

  /**
   * fromCallable :
   *
   * <p>- similar as defer, but it starts to execute when being subscribed, a single result is then
   * returned
   *
   * <p>https://blog.csdn.net/qq_33204709/article/details/136869310
   */
  @Test
  public void test_callable() throws Exception {

    // V1
    fromCallable(() -> "9999").subscribe(System.out::println);

    // V2 (GPT)
    Callable<String> callable =
        new Callable<String>() {
          @Override
          public String call() throws Exception {
            return "7777";
          }
        };

    fromCallable(callable)
        .subscribe(
            new Consumer<String>() {
              @Override
              public void accept(String s) {
                System.out.println(s);
              }
            });

    //        fromCallable(x -> {
    //           return fromCallable(new Callable<Object>() {
    //               @Override
    //               public String call() throws Exception {
    //                   return "7777";
    //               }
    //           });
    //        }).subscribe(System.out::println);

  }

  @Test
  public void test_1() {

    //    Mono<Integer> data1 = Mono.just(1);

    // V1 : regular style
    Mono<String> data2 =
        Mono.fromCallable(
            new Callable<String>() {
              @Override
              public String call() throws Exception {
                return "7777";
              }
            });

    data2.subscribe(System.out::println);

    // V2 : lambda expression :  (since there is only 1 method called fromCallable under Mono)
    Mono<String> data3 = Mono.fromCallable(() -> "yooooo");

    data3.subscribe(System.out::println);
  }

  /** Callable call (NO lambda expression) method without param */
  @Test
  public void test_without_lambda_expression() {
    // without lambda
    rxCall().subscribe(System.out::println);
  }

  /** Callable call (lambda expression) method without param */
  // https://github.com/yennanliu/til#20240908
  @Test
  public void test_with_lambda_expression() {
    // with lambda
    rxCallLambda().subscribe(System.out::println);
  }

  /** Callable call (NO lambda expression) method with param */
  @Test
  public void test_without_lambda_expression_method_with_param() {
    // without lambda
    rxCallParam("123").subscribe(System.out::println);
  }

    /** Callable call (lambda expression) method with param */
    @Test
    public void test_with_lambda_expression_with_param() {
        // with lambda
        rxCallParamLambda("123").subscribe(System.out::println);
    }


  /** CALLABLE CALL */
  private Mono<String> rxCallLambda() {
    return fromCallable(() -> myFunc());
  }

  private Mono<String> rxCall() {
    // V1
    Callable<String> callable =
        new Callable<String>() {
          @Override
          public String call() throws Exception {
            return myFunc();
          }
        };

    // V2
    // Callable<String> callable = () -> myFunc();

    return fromCallable(callable);
  }

    private Mono<String> rxCallParamLambda(String param) {
        return fromCallable(() -> myFuncWithParam(param));
    }

  private Mono<String> rxCallParam(String param) {
    // V1
    Callable<String> callable =
        new Callable<String>() {
          @Override
          public String call() throws Exception {
            /**
             * NOTE !!! below
             *
             * <p>1. no need to setup param in call() 2. ONLY need setup param when call the actual
             * method (e.g. myFuncWithParam(param)) 3. rest of things remain same
             */
            return myFuncWithParam(param);
          }
        };

    // V2
    // Callable<String> callable = () -> myFunc();

    return fromCallable(callable);
  }

  /** METHOD */
  private String myFunc() {
    return "yooo";
  }

  private String myFuncWithParam(String x) {
    return "input = " + x;
  }

}
