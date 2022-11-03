package dev;

import dev.bean.Car;
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

  @Test
  public void test3(){

    ArrayList<String> pdfFiles = new ArrayList();
    pdfFiles.add("xxx/yyy/my_pdf1.pdf");
    pdfFiles.add("xxx/yyy/my_pdf2.pdf");
    pdfFiles.add("zzz/yyy/my_pdf1.pdf");
    pdfFiles.add("zzz/yyy/report_8267c0f1baf74c958b36d812bba9be1a.pdf");

    System.out.println(">>> pdfFiles = " + pdfFiles);

    List<String> filteredPDF = pdfFiles.stream()
        .filter(x -> x.contains("8267c0f1baf74c958b36d812bba9be1a")).collect(Collectors.toList());

    System.out.println(">>> filteredPDF = " + filteredPDF);
    System.out.println(filteredPDF.size());

    if (filteredPDF.size() > 1){
      System.out.println(">>> filteredPDF = " + filteredPDF);
    }

    List<String> filteredPDF2 = pdfFiles.stream()
        .filter(x -> x.contains("fwevwscsafwe")).collect(Collectors.toList());

    System.out.println(">>> filteredPDF2 = " + filteredPDF2);

    if (filteredPDF2.size() > 1){
      System.out.println(">>> filteredPDF2.get(0) = " + filteredPDF2.get(0));
    }
  }

}
