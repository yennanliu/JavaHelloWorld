package com.yen.Util;

import rx.Observable;

public class MathUtil {

    public static int getCumSum(int range){
        int res = 0;
        for (int i = 1; i < range+1; i++){
            res += i;
        }
        return res;
    }

    //  0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static int getFibSum(int range){
        int first = 0;
        int second = 1;
        int res = 0;
        if (range==0){
            return first;
        }
        if (range==1){
            return second;
        }
//        for (int i = 2; i < range; i++){
//           res += (getFibSum(i-1) + getFibSum(i-2));
//        }

        return getFibSum(range-1) + getFibSum(range-2);
    }

//    public static Observable<Integer> getFibSumRX(int range){
//        // TODO : check Observable.create
//        return Observable.just(emitter -> {
//
//            int first = 0;
//            int second = 1;
//            if (range==0){
//                return Observable.just(0);
//            }
//            if (range==1){
//                return Observable.just(1);
//            }
//
//            for (int i = 2; i < range; i++) {
//                int next = first + second;
//                //emitter.onNext(next);
//                first = second;
//                second = next;
//            }
//        })
//        return null;
//    }


    // TODO : fix below
    public static Observable<Integer> fibonacci(int n) {
        return Observable.create(emitter -> {
            int first = 0;
            int second = 1;

            if (n == 0) {
                emitter.onNext(first);
                emitter.onCompleted();
                return;
            }
            if (n == 1) {
                emitter.onNext(second);
                emitter.onCompleted();
                return;
            }

            emitter.onNext(first); // F(0)
            emitter.onNext(second); // F(1)

            for (int i = 2; i < n; i++) {
                int next = first + second;
                emitter.onNext(next);
                first = second;
                second = next;
            }
            emitter.onCompleted();
        });
    }

    public static Observable<Integer> getFibSumRX(int range) {
        return fibonacci(range)
                .reduce(0, Integer::sum); // Sum the emitted Fibonacci numbers
               // .toBlocking(); // Get the result
    }
    
}
