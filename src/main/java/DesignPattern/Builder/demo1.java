package DesignPattern.Builder;

// https://www.runoob.com/design-pattern/builder-pattern.html

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  建造者模式（Builder Pattern）使用多個簡單的物件一步一步建構成一個複雜的物件。
 *
 *  這種類型的設計模式屬於創建型模式，它提供了一種創建物件的最佳方式。
 *
 *  一個 Builder 類別會一步一步建構最終的物件。 該 Builder 類別是獨立於其他物件的。
 *
 *
 */

interface Item{
    public String name();
    public Packing packing();
    public float price();
}

interface Packing{
    public String pack();
}

class Wrapper implements Packing{

    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing{

    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

//    @Override
//    public float price() {
//        return 0;
//    }
}

abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    // TODO : check if necessary ?
//    @Override
//    public abstract float price();
}

class VegBurger extends Burger{

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.0f;
    }

}

class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}

// meal instance
class Meal{

    // attr
    private List<Item> items = new ArrayList<>();

    // method
    void addItem(Item item){
        items.add(item);
    }

    float getCost(){
        float cost = 0.0f;
        for (Item item: items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}

// mealBuilder
class MealBuilder{

    // method
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return meal;
    }

}

public class demo1 {

    public static void main(String[] args) {

        // run
        MealBuilder builder = new MealBuilder();

        Meal vegMeal = builder.prepareVegMeal();
        vegMeal.showItems();

        Meal NonVegMeal = builder.prepareNonVegMeal();
        NonVegMeal.showItems();
    }

}
