package com.yen.CourseV1;

// https://youtu.be/ApUUN55V2RE?si=zOpzZ14He9IzmqGZ

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class part2 {
  public static void main(String[] args) {

      /** Example 1 */
      // Observable via just
      Observable<String> observable = Observable.just("item 1", "item 2");

      // implement Observer
      Observer<String> observer = new Observer<String>() {
          @Override
          public void onCompleted() {
              System.out.println("On Completed called !");
          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onNext(String s) {
              System.out.println("onNext -- " + s);
          }
      };

    // run
    /**
     *  V1
     *
     *  observable.subscribe(observer)
     *
     * 	•	Custom Observer: In this case, you are explicitly creating an Observer instance, which implements the Observer<T> interface. This gives you full control over how you handle the lifecycle of the subscription, including:
     * 	•	onNext(T t): Handles each emitted item.
     * 	•	onError(Throwable e): Handles any errors that occur during the emission.
     * 	•	onCompleted(): Handles the completion event when the observable finishes emitting items.
     * 	•	Full Lifecycle Handling: You can define custom logic in each of these methods (onNext, onError, onCompleted), which allows you to respond to each stage of the data emission process.
     *
     *
     *  -	This example will print each item prefixed with “onNext – “ as it is emitted.
     * 	•	It will also print “On Completed called !” when the observable completes.
     * 	•	You can handle errors in the onError method.
     */
    observable.subscribe(observer);

    /**
     *  V2
     *
     *  - Lambda Expression for Simplicity: This is a shorthand way to subscribe to the observable. Here, you provide a lambda expression that handles only the onNext(T t) event. It is a more concise and convenient way to subscribe when you don’t need to handle errors or completion explicitly.
     * 	•	Default Error and Completion Handling: In this case:
     * 	•	Errors will be handled by the default implementation, which may simply log them or terminate the application if not caught elsewhere.
     * 	•	The completion event is ignored, meaning you won’t get notified when the observable has finished emitting items.
     *
     * 	•	This example will print each item as it is emitted, but without any prefix or additional logic.
     * 	•	There is no explicit handling of completion or errors; they are handled by default.
     */
    observable.subscribe(x -> System.out.println(x));

    /**
     *  Summary for above difference :
     *
     * 	•	Control: observable.subscribe(observer) provides full control over the entire lifecycle of the subscription, allowing you to customize how you handle emitted items, errors, and completion.
     * 	•	Simplicity: observable.subscribe(x -> System.out.println(x)) is simpler and more concise but only handles the onNext event, with default behavior for errors and completion.
     * 	•	Use Case: Use observable.subscribe(observer) when you need to manage all aspects of the subscription (e.g., handling errors, knowing when the observable completes). Use the lambda shorthand when you only care about the emitted items and want quick, simple output.
     */

    /** Example 2 */
    List<Integer> numbers = new ArrayList<>();
      numbers.add(1);
      numbers.add(2);

      // Observable from iterable
      Observable<Integer> observable2 = Observable.from(numbers);

      Observer<Integer> observer2 = new Observer<Integer>() {
          @Override
          public void onCompleted() {
              System.out.println("On Completed called !");
          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onNext(Integer integer) {
              System.out.println("onNext -- " + integer);
          }
      };

      // run
      observable2.subscribe(observer2);
  }

}
