package Advances.Enumeration;

// https://walkonnet.com/archives/8013

import org.junit.jupiter.api.Test;

public class demo5 {

    @Test
    public void test1(){

        Color c1 = Color.RED;
        System.out.println(c1.getInfo());
        System.out.println(c1);
        System.out.println(c1.index);
        System.out.println(c1.name);

        System.out.println("===============");

        Color[] arr = Color.values();
        for (Color c : arr){
            System.out.println(">>> c = " + c);
        }
    }

    @Test
    public void test2(){

        // TODO : check below syntax/logic
        Food d1 = Food.Dessert.CAKE;
        System.out.println(d1);

        Food d2 = Food.Dessert.FRUIT;
        System.out.println(d2);
    }

    public interface Behaviour {
        void print();
        String getInfo();
    }

    public enum Color implements Behaviour{
        RED("紅色", 1), GREEN("綠色", 2), BLANK("白色", 3), YELLOW("黃色", 4);
        // 成員變量
        private String name;
        private int index;
        // 構造方法
        private Color(String name, int index) {
            this.name = name; this.index = index;
        }
        //接口方法
        @Override
        public String getInfo() {
            return this.name;
        }
        //接口方法
        @Override
        public void print() {
            System.out.println(this.index+":"+this.name);
        }
    }

    public interface Food {
        enum Coffee implements Food{
            BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
        }
        enum Dessert implements Food{
            FRUIT, CAKE, GELATO
        }
    }

}
