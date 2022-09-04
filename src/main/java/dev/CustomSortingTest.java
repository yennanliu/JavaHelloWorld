package dev;

import dev.bean.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 *
 *  https://segmentfault.com/q/1010000041496148
 *  https://www.jianshu.com/p/5a3361959ae7
 */

public class CustomSortingTest {

    @Test
    public void test1(){

        Data d1 = new Data("1",null,null);
        Data d2 = new Data("2",null,null);
        Data d3 = new Data("3",null,null);

        Data[] dataList = new Data[]{d1,d3,d2};

        Arrays.stream(dataList).forEach(System.out::println);

        // NOTE : in order to use Arrays.sort, we HAVE to implement compareTom method in data bean first
        Arrays.sort(dataList);

        System.out.println();

        Arrays.stream(dataList).forEach(System.out::println);
    }

}
