package com.yen.dev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachStreamTest {

    @Test
    public void test_1(){
    // from GPT

    /**
     *   forEach demo
     *
     *  - Using forEach:
     *  - Here, you’re manually creating a new list and using forEach to add the transformed elements to it.
     *
     *  - 	Purpose: The forEach method is used to perform an action on each element of the list. It’s typically used for side effects (like printing, modifying external variables, etc.).
     *
     *  	•	Characteristics:
     * 	        •	No Return Value: forEach is a terminal operation that does not return a value. It’s a void method, so you can’t use its result directly.
     * 	        •	Side Effects Only: If you want to modify an external variable or perform some action on each element without changing the original list or creating a new list, forEach is appropriate.
     * 	        •	Scope of y: The variable y is local to the lambda and not accessible outside of it. It doesn’t contribute to building a new collection or modifying the list itself.
     */
    List<Integer> x_list = Arrays.asList(1, 2, 3);
        List<Integer> result = new ArrayList<>();
        x_list.forEach(x -> {
            result.add(x * 2);
        });
        // `result` will contain [2, 4, 6]

        /**
         *  stream demo
         *
         *  - Using stream().map(...).collect(...):
         *  - This approach is more concise and functional, directly returning a new list with the transformed elements.
         *
         * - Purpose: The map method is used to transform each element of the stream (which is derived from the list) into a new form. The collect(Collectors.toList()) operation gathers these transformed elements into a new list.
         *
         *
         *  	•	Characteristics:
         * 	        •	Transforms and Returns: map is an intermediate operation that transforms each element in the stream and returns a new stream of the transformed elements. This stream is then collected into a list using collect.
         * 	        •	Immutable Operation: The original list (x_list) remains unchanged. Instead, a new list (result) is created with the transformed elements.
         * 	        •	Result of Transformation: The transformed elements are collected into a new list that you can use outside the stream pipeline.
         *
         */
        List<Integer> x_list2 = Arrays.asList(1, 2, 3);
        List<Integer> result2 = x_list.stream().map(x -> x * 2).collect(Collectors.toList());
        // `result2` will contain [2, 4, 6]


        /**
         *  In summary,
         *
         *  - forEach is for side effects and does not produce a new collection,
         *  - while stream().map(...).collect(...) is used to transform data and produce a new collection.
         *
         *
         *  - Key Differences:
         *
         * 	•	Mutability vs. Immutability:
         * 	•	forEach: Typically used when you want to perform operations that don’t need to modify the original list or produce a new list. It’s more about applying side effects.
         * 	•	stream().map(...).collect(...): Used when you want to transform the list and create a new list with the transformed elements. It’s functional and does not modify the original list.
         * 	•	Side Effects:
         * 	•	forEach: Often associated with side effects, such as modifying external state, logging, etc.
         * 	•	map: Purely functional; transforms data and produces new data without side effects (unless you deliberately introduce them).
         * 	•	Return Value:
         * 	•	forEach: Does not return anything; the lambda’s return value is ignored.
         * 	•	map(...).collect(...): Returns a new list containing the results of the transformation.
         *
         */

    }

}
