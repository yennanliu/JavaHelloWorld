package DesignPattern.Factory;

// https://www.runoob.com/design-pattern/factory-pattern.html

/**
 * 工廠模式（Factory Pattern）是 Java 中最常用的設計模式之一。
 *
 * <p>這種類型的設計模式屬於創建型模式，它提供了一種創建物件的最佳方式。
 *
 * <p>工廠模式提供了一種將物件的實例化過程封裝在工廠類別中的方式。
 *
 * <p>透過使用工廠模式，可以將物件的建立與使用程式碼分離，提供一種統一的介面來建立不同類型的物件。
 *
 * <p>在工廠模式中，我們在創建物件時不會對客戶端暴露創建邏輯，並且是透過使用一個共同的介面來指向新建立的物件。
 *
 * <p>意圖：定義一個創建對象的接口，讓其子類自己決定實例化哪一個工廠類，工廠模式使其創建過程延遲到子類進行。
 *
 * <p>主要解決：主要解決介面選擇的問題。
 *
 * <p>何時使用：我們明確地規劃不同條件下建立不同實例時。
 *
 * <p>如何解決：讓其子類別實現工廠接口，返回的也是一個抽象的產品。
 *
 * <p>關鍵程式碼：創建過程在其子類別執行。
 *
 * <p>應用實例： 1、您需要一輛汽車，可以直接從工廠裡面提貨，而不用去管這輛汽車是怎麼做出來的，以及這個汽車裡面的具體實現。 2、Hibernate 換資料庫只要換方言和驅動就可以。
 *
 * <p>優點： 1、一個呼叫者想建立一個對象，只要知道其名稱就可以了。 2.擴展性高，如果想增加一個產品，只要擴充一個工廠類就可以。 3.屏蔽產品的具體實現，呼叫者只關心產品的介面。
 *
 * <p>缺點：每次增加一個產品時，都需要增加一個具體類別和物件實現工廠，使得系統中類別的數量成倍增加，在一定程度上增加了系統的複雜度，同時也增加了系統具體類別的 依賴。 這並不是什麼好事。
 *
 * <p>使用場景： 1、日誌記錄器：記錄可能記錄到本機硬碟、系統事件、遠端伺服器等，使用者可以選擇記錄日誌到哪裡。 2.資料庫訪問，當使用者不知道最後系統採用哪一類資料庫，以及資料庫可能有變更。
 * 3.設計一個連接伺服器的框架，需要三個協議，"POP3"、"IMAP"、"HTTP"，可以把這三個當作產品類，共同實作一個介面。
 *
 * <p>注意事項：作為一種建立類別模式，在任何需要產生複雜物件的地方，都可以使用工廠方法模式。 有一點要注意的地方就是複雜對象適合使用工廠模式，而簡單對象，特別是只需要透過 new
 * 就可以完成創建的對象，無需使用工廠模式。 如果使用工廠模式，就需要引入一個工廠類，會增加系統的複雜度。
 *
 * <p>工廠模式包含以下幾個核心角色：
 *
 * <p>抽象產品（Abstract Product）：定義了產品的共同介面或抽象類別。 它可以是具體產品類別的父類別或接口，規定了產品物件的共同方法。 具體產品（Concrete
 * Product）：實現了抽象產品接口，定義了具體產品的特定行為和屬性。 抽象工廠（Abstract Factory）：聲明了創建產品的抽象方法，可以是介面或抽象類別。
 * 它可以有多個方法用於創建不同類型的產品。 具體工廠（Concrete Factory）：實現了抽象工廠接口，負責實際創建具體產品的物件。
 */
interface Vehicle {
  void drive();
}

class Toyota implements Vehicle {

  @Override
  public void drive() {
    System.out.println("Toyota drive");
  }
}

class Lexus implements Vehicle {

  @Override
  public void drive() {
    System.out.println("Lexus drive");
  }
}

class CarFactory {

  // attr
  private final Vehicle vehicle;

  // constructor
  public CarFactory(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public void run() {
    System.out.println(">>> this.vehicle = " + this.vehicle.getClass());
    // TODO : optimize with switch-case
    if (Toyota.class.equals(this.vehicle.getClass())) {
      System.out.println("this is a Toyota car");
      vehicle.drive();
      // return this.vehicle;
    } else if (Lexus.class.equals(this.vehicle.getClass())) {
      System.out.println("this is a Lexus car");
      vehicle.drive();
    } else {
      System.out.println("this is a default car");
    }
  }
}

public class demo1 {

  public static void main(String[] args) {

    Toyota toyota_car = new Toyota();
    Lexus lexus_car = new Lexus();

    CarFactory carFactory_1 = new CarFactory(toyota_car);
    CarFactory carFactory_2 = new CarFactory(lexus_car);

    carFactory_1.run();
    carFactory_2.run();
  }
}
