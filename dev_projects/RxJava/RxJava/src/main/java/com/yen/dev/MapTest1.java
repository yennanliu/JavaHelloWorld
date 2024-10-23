package com.yen.dev;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MapTest1 {

    @Test
    public void test_1() throws InterruptedException {
        List<String> myList = new ArrayList<>();
        String data1 = "data 1";
        String data2 = "data 2";
        myList.add(data1);
        myList.add(data2);

        Single<List<String>> myData = Single.just(myList);

        /**
         *
         * Key Changes:
         *
         * Transforming the Response:
         *      The myData variable is transformed using map to
         *      produce a Single<CustomResponse>.
         *
         * CustomResponse Class:
         *      A CustomResponse class is introduced with a builder pattern
         *      to simulate the response building
         *
         * Method for Transformation:
         *     The transformToCustomResponse method takes
         *     a List<String> and builds a CustomResponse object.
         */
        // Transforming the Single<List<String>> to a new structure
        Single<CustomResponse> res = myData.map(this::transformToCustomResponse);

        // consume
        res.subscribe(x->System.out.println(x));

        Thread.sleep(3);
    }

    // This method constructs a CustomResponse object
    public CustomResponse transformToCustomResponse(List<String> input) {
        // Assuming CustomResponse has a constructor or builder
        return CustomResponse.newBuilder()
                .addAllItems(input) // Adding all items from the list
                .setSomeOtherField("example") // Set any other necessary fields
                .build();
    }

    // Example response class (you'd define this according to your needs)
    public static class CustomResponse {

        public static Builder newBuilder() {
            return new Builder();
        }

        public static class Builder {
            private List<String> items = new ArrayList<>();
            private String someOtherField;

            public Builder addAllItems(List<String> items) {
                this.items.addAll(items);
                return this;
            }

            public Builder setSomeOtherField(String value) {
                this.someOtherField = value;
                return this;
            }

            public CustomResponse build() {
                // Create and return the CustomResponse instance
                return new CustomResponse(this);
            }
        }

        private CustomResponse(Builder builder) {
            // Initialize fields from builder
        }

        @Override
        public String toString() {
            return "CustomResponse = {}";
        }
        // Fields and builder methods
    }

}
