package Advances.Enumeration;

// https://walkonnet.com/archives/8013
// https://www.runoob.com/java/java-enum.html

import org.junit.jupiter.api.Test;

public class demo4 {

    @Test
    public void test1(){

        Color1 c1 = Color1.RED;
        System.out.println(">>> c1 = " + c1);

        for (Color1 c : Color1.values()){
            System.out.println(">>> c.name = " + c.name + " c.index = " + c.index);
        }
    }

    @Test
    public void test2(){

        for (Car c : Car.values()){
            System.out.println(">>> c.nominalName = " + c.nominalName + " c.name = " + c.name);
        }
    }

    public enum Color1 {
        RED("紅色", 1), GREEN("綠色", 2), BLANK("白色", 3), YELLOW("黃色", 4);

        // 成員變量
        private String name;
        private int index;

        // 構造方法
        private Color1(String name, int index) {
            this.name = name; this.index = index;
        }

        //覆蓋方法
        @Override
        public String toString() {
            return this.index+"_"+this.name;
        }
    }

    public enum Car{

        Benz("BENZ", "benz"),
        BMW("BMW", "bmw"),
        TESLA("TESLA", "tesla");

        private String nominalName;
        private String name;

        private Car(String nominalName, String name){
            this.nominalName = nominalName;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.nominalName + "-" + this.name;
        }
    }

}
