package dev;

/**
 *  Ref :
 *   - https://github.com/yennanliu/til/blob/master/doc/pic/stream_map1.png
 */

import dev.bean.Car;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest1 {

    /**
     *
     *  Stream map return demo
     */
    @Test
    public void MapTest1(){

        Car car1 = new Car(1,"TESLA",1000);
        Car car2 = new Car(2,"BENZ",3000);
        Car car3 = new Car(3,"LEXUS",2000);

        // https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
        Car[] cars = new Car[]{car1, car2, car3};
        List<Car> car_list = Arrays.asList(cars);

        car_list.stream().forEach(x -> System.out.println(x));

        System.out.println("");

        List<String> brand_list = car_list.stream().map(x -> {
            String brand = x.getBrand();
            return brand;
        }).collect(Collectors.toList());

        System.out.println(brand_list);
    }


    /**
     *  GroupBy basic
     *
     *  Map<String, List<MyReport>> monthReportMap = myReport.stream()
     *      .collect(Collectors.groupingBy(MyReport::getOwnerGroupKey));
     */
    @Test
    public void GroupByTest1(){

        Car car1 = new Car(1,"TESLA",1000);
        Car car2 = new Car(2,"BENZ",3000);
        Car car3 = new Car(3,"LEXUS",2000);
        Car car4 = new Car(4,"LEXUS",1222);
        Car car5 = new Car(5,"LEXUS",9000);

        // https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
        Car[] cars = new Car[]{car1, car2, car3, car4, car5};
        List<Car> car_list = Arrays.asList(cars);

        Map<String, List<Car>> groupByResult = car_list
                .stream()
                .collect(Collectors.groupingBy(x -> x.getBrand())
                );

        System.out.println(">>> groupByResult = " + groupByResult); //  groupByResult = {BENZ=[Car{id=2, brand='BENZ', price=3000.0}], LEXUS=[Car{id=3, brand='LEXUS', price=2000.0}, Car{id=4, brand='LEXUS', price=1222.0}, Car{id=5, brand='LEXUS', price=9000.0}], TESLA=[Car{id=1, brand='TESLA', price=1000.0}]}

        System.out.println();

        // https://stackoverflow.com/questions/49605558/is-it-possible-to-use-foreach-in-groupingby-in-java-stream
        groupByResult.forEach((x,y) -> System.out.println("x = " + x + " y = " + y));
    }

    /**
     *  1) groupingBy Car::getId
     *  2) Collectors.groupingBy(Car::getIdAndBrand) : group by custom get method
     */
    @Test
    public void GroupByTest2(){

        Car car1 = new Car(1,"TESLA",1000);
        Car car2 = new Car(2,"BENZ",3000);
        Car car3 = new Car(3,"LEXUS",2000);
        Car car4 = new Car(4,"LEXUS",1222);
        Car car5 = new Car(5,"LEXUS",9000);
        Car car6 = new Car(1,"TESLA",1000);

        Car[] cars = new Car[]{car1, car2, car3, car4, car5, car6};
        List<Car> car_list = Arrays.asList(cars);

        Map<Integer, List<Car>> groupByResult = car_list
                .stream()
                .collect(Collectors.groupingBy(Car::getId)
                );

        System.out.println(">>> groupByResult = " + groupByResult);

        System.out.println();

        // https://stackoverflow.com/questions/49605558/is-it-possible-to-use-foreach-in-groupingby-in-java-stream
        groupByResult.forEach((x,y) -> System.out.println("x = " + x + " y = " + y));


        Map<String, List<Car>> groupByResult2 = car_list
                .stream()
                .collect(Collectors.groupingBy(Car::getIdAndBrand)
                );

        System.out.println(">>> groupByResult2 = " + groupByResult2);
    }

}
