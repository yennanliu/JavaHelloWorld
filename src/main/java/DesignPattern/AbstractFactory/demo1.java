package DesignPattern.AbstractFactory;

// https://www.runoob.com/design-pattern/abstract-factory-pattern.html

/**
 *  抽象工廠模式包含以下幾個核心角色：
 *
 * 抽象工廠（Abstract Factory）：聲明了一組用於建立產品物件的方法，每個方法對應一種產品類型。 抽象工廠可以是介面或抽象類別。
 * 具體工廠（Concrete Factory）：實現了抽象工廠接口，負責創建具體產品物件的實例。
 * 抽象產品（Abstract Product）：定義了一組產品物件的共同介面或抽象類別，描述了產品物件的公共方法。
 * 具體產品（Concrete Product）：實現了抽象產品接口，定義了具體產品的特定行為和屬性。
 *
 *
 * 意圖：提供一個建立一系列相關或相互依賴物件的接口，而無需指定它們特定的類別。
 *
 * 主要解決：主要解決介面選擇的問題。
 *
 * 何時使用：系統的產品有多於一個的產品族，而系統只消費其中某一族的產品。
 *
 * 如何解決：在一個產品族裡面，定義多個產品。
 *
 * 關鍵代碼：在一個工廠聚合多個同類產品。
 *
 */

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle:: draw !!!");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square:: draw !!!");
    }
}

interface Color{
    void fill();
}

class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Red:: fill !!!");
    }
}

class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Blue:: fill !!!");
    }
}

/** Abstract Factory */
abstract class AbstractFactory{
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

// class extend Abstract Factory
class ShapeFactory extends AbstractFactory{

    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
//        } else if(color.equalsIgnoreCase("GREEN")){
//            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}

/** Factory producer for creating factory
 *
 *  -> create factory via passing shape / color
 */
class FactoryProducer{

    static AbstractFactory createFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle:: draw !!!");
    }
}

public class demo1 {

    public static void main(String[] args) {

        /** get shape factory */
        AbstractFactory shapeFactory = FactoryProducer.createFactory("SHAPE");

        // get Circle instance
        Shape circle = shapeFactory.getShape("CIRCLE");

        // call method
        circle.draw();

        // get RECTANGLE instance
        Shape rectangle = shapeFactory.getShape("RECTANGLE");

        rectangle.draw();


        /** get color factory */
        AbstractFactory colorFactory = FactoryProducer.createFactory("COLOR");

        // get color instance
        Color blue = colorFactory.getColor("BLUE");

        blue.fill();


    }

}
