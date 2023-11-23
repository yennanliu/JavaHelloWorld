package DesignPattern.Decorator;

// https://www.runoob.com/design-pattern/decorator-pattern.html

/**
 * 裝飾器模式
 *
 * 裝飾器模式（Decorator Pattern）允許在一個現有的物件上添加新的功能，
 *
 * 同時又不改變其結構。 這種類型的設計模式屬於結構型模式，它是作為現有的類別的包裝。
 *
 * 裝飾器模式透過將物件包裝在裝飾器類別中，以便動態地修改其行為。
 *
 * 這種模式創建了一個裝飾類，用來包裝原有的類，並在保持類方法簽名完整性的前提下，提供了額外的功能。
 *
 * 我們透過下面的實例來示範裝飾器模式的用法。 其中，我們將把一個形狀裝飾上不同的顏色，同時又不改變形狀類。
 *
 *
 *
 *
 *
 * 意圖：動態地為一個物件添加一些額外的職責。 就增加功能來說，裝飾器模式相比產生子類別更為靈活。
 *
 * 主要解決：一般的，我們為了擴展一個類別經常使用繼承方式實現，由於繼承為類別引入靜態特徵，並且隨著擴展功能的增多，子類別會很膨脹。
 *
 * 何時使用：在不想增加很多子類別的情況下擴展類別。
 *
 * 如何解決：將具體功能職責劃分，同時繼承裝飾者模式。
 *
 * 關鍵程式碼： 1、Component 類別扮演抽象角色，不應該具體實作。 2.修飾類別引用和繼承 Component 類，具體擴展類別重寫父類別方法。
 *
 * 應用實例： 1、孫悟空有 72 變，當他變成"廟宇"後，他的根本還是一隻猴子，但是他又有了廟宇的功能。 2.不論一幅畫有沒有畫框都可以掛在牆上，但是通常都是有畫框的，實際上是畫框被掛在牆上。 在掛在牆上之前，畫可以被蒙上玻璃，裝到框框裡；這時畫、玻璃和畫框形成了一個物體。
 *
 * 優點：裝飾類別和被裝飾類別可以獨立發展，不會相互耦合，裝飾模式是繼承的一個替代模式，裝飾模式可以動態擴展一個實現類別的功能。
 *
 * 缺點：多層裝飾比較複雜。
 *
 * 使用場景： 1、擴充一個類別的功能。 2、動態增加功能，動態撤銷。
 *
 * 注意事項：可代替繼承。
 *
 * 裝飾器模式包含以下幾個核心角色：
 *
 * 抽像元件（Component）：定義了原始物件和裝飾器物件的公共介面或抽象類別，可以是具體元件類別的父類別或介面。
 * 具體組件（Concrete Component）：是被裝飾的原始對象，它定義了需要添加新功能的對象。
 * 抽象裝飾器（Decorator）：繼承自抽象組件，它包含了一個抽象組件對象，並定義了與抽象組件相同的接口，同時可以透過組合方式持有其他裝飾器對象。
 * 具體裝飾器（Concrete Decorator）：實作了抽象裝飾器的接口，負責為抽象組件添加新的功能。 具體裝飾器通常會在呼叫原始物件的方法之前或之後執行自己的操作。
 * 裝飾器模式透過嵌套包裝多個裝飾器對象，可以實現多層次的功能增強。 每個特定裝飾器類別都可以選擇性地增加新的功能，同時保持物件介面的一致性。
 *
 *
 */

// interface
interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

// shape abstract class
abstract class ShapeDecorator implements Shape{

    // attr
    protected Shape decoratedShape;

    // constructor
    ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

// class extend ShapeDecorator
class RedShapeDecorator extends ShapeDecorator{

    RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
       // super.draw();
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}

public class demo1 {

    public static void main(String[] args) {

        // run

        // decorate Shape with RedShapeDecorator

        Shape circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());

        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }

}
