package dev;

import dev.bean.Data;
import dev.bean.Data2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void test2(){

        Data d1 = new Data("1","123",null);
        Data d2 = new Data("2","456",null);
        Data d3 = new Data("3","others",null);
        Data d4 = new Data("4","898",null);

        //Data[] dataList = new Data[]{d1,d4,d3,d2};
        //List<Data> dataList = Arrays.asList(d3, d1, d4, d2);
        //List<Data> dataList = Arrays.asList(d1,d3,d2);
        Data[] dataList = new Data[]{d1,d3,d2,d4};

        Arrays.stream(dataList).forEach(System.out::println);

        System.out.println();

        // NOTE : in order to use Arrays.sort, we HAVE to implement compareTom method in data bean first
//        dataList.remove(idx);
//        dataList.forEach(System.out::println);
        Arrays.sort(dataList);

        System.out.println();

        Arrays.stream(dataList).forEach(System.out::println);
    }


    @Test
    public void test2_x(){

        Data d1 = new Data("1","123",null);
        Data d2 = new Data("2","456",null);
        Data d3 = new Data("3","others",null);
        Data d4 = new Data("4","898",null);

        List<Data> dataList = new ArrayList<>();

        dataList.add(d1);
        dataList.add(d3);
        dataList.add(d2);
        dataList.add(d4);

        Data[] dataList2 = dataList.stream().toArray(Data[]::new);

        Arrays.stream(dataList2).forEach(System.out::println);

        Arrays.sort(dataList2);

        System.out.println();

        Arrays.stream(dataList2).forEach(System.out::println);
    }

    @Test
    public void test2_1(){

        Data d1 = new Data("1",null,null);
        Data d2 = new Data("2",null,null);
        Data d3 = new Data("3","others",null);
        Data d4 = new Data("4",null,null);

        //Data[] dataList = new Data[]{d1,d4,d3,d2};
        List<Data> dataList = new ArrayList<>();
        //List<Data> dataList = Arrays.asList(d1, d2, d3);
        dataList.add(d1);
        dataList.add(d2);
        dataList.add(d3);

        Integer idx = dataList.indexOf(d3);

        System.out.println(">>> idx = " + idx);

        // Initial list
        System.out.println("Initial List: " + dataList);

        // remove element
        dataList.remove(idx);

        // Final list
        System.out.println("Final List: " + dataList);

    }

    @Test
    public void test2_2(){

        Data2 d1 = new Data2("1", "others", "100");
        Data2 d2 = new Data2("2", "a", "900000");
        Data2 d3 = new Data2("3", "b", "200");
        Data2 d4 = new Data2("4", "others", "70000");
        Data2 d5 = new Data2("5", "d", "300");

        //Data[] dataList = new Data[]{d1,d4,d3,d2};
        List<Data2> dataList = new ArrayList<>();
        //List<Data> dataList = Arrays.asList(d1, d2, d3);
        dataList.add(d1);
        dataList.add(d4);
        dataList.add(d2);
        dataList.add(d3);
        dataList.add(d5);

        // Initial list
        System.out.println("Initial List: " + dataList);

        Collections.sort(dataList, (o1, o2)->{
            String id1 = o1.getId();
            String id2 = o2.getId();
            String type1 = o1.getType();
            String type2 = o2.getType();
            String value1 = o1.getValue();
            String value2 = o2.getValue();
            if (type1.equals("others") && !type2.equals("others")){
                return 1;
            }else if(!type1.equals("others") && type2.equals("others")){
                return -1;
            } else if (type1.equals("others") && type2.equals("others")) {
                return 0;
            }
            return (int) (Double.parseDouble(value1) - Double.parseDouble(value2));
        });

        // Final list
        System.out.println("Final List: " + dataList);
    }

    @Test
    public void test3(){

        // https://www.digitalocean.com/community/tutorials/java-list-remove-methods-arraylist-remove

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);

        boolean isRemoved = list.remove("C");
        System.out.println(list);
        System.out.println(isRemoved);

        isRemoved = list.remove("X");
        System.out.println(list);
        System.out.println(isRemoved);

    }

    @Test
    public void test4(){

        // https://www.geeksforgeeks.org/list-removeint-index-method-in-java-with-examples/#:~:text=The%20remove(int%20index)%20method,the%20left%20in%20the%20List.

        List<Integer> list = new ArrayList<Integer>(5);

        // Add elements to the list
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        // Index from which you want to remove element
        int index = 2;

        // Initial list
        System.out.println("Initial List: " + list);

        // remove element
        list.remove(index);

        // Final list
        System.out.println("Final List: " + list);
    }

}
