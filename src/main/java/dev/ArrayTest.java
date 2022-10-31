package dev;

import dev.bean.Car;
import freemarker.template.utility.StringUtil;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ArrayTest {

  @Test
  public void test1(){

    List<Car> cars = new ArrayList<>();
    cars.add(new Car(1, "XX", 10.1));
    cars.add(new Car(2, "dd", 2));
    cars.add(new Car(3, "zz", 3.0));

    System.out.println(cars);
  }

  @Test
  public void test2(){

    ArrayList<String> places = new ArrayList<String>();
    places.add("Buenos Aires");
    places.add("Córdoba");
    places.add("La Plata");

    List<List<String>> csvData = new ArrayList<>();

    //csvData.add(new ArrayList<>("1",));
    List<String> places2 = places.stream().map(
        x -> {
          String y = x + " 123";
          //String y = "123";
          return y;
        }
    ).collect(Collectors.toList());

    System.out.println(places2);
  }

}
