package dev;

/**
 *  Ref :
 *   - https://github.com/yennanliu/til/blob/master/doc/pic/stream_map1.png
 */

import dev.bean.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapTest {

    @Test
    public void test1(){

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

}
