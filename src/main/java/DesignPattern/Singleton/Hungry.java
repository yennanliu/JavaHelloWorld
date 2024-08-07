package DesignPattern.Singleton;

/**
 * 單例模式（Singleton Pattern）是 Java 中最簡單的設計模式之一。
 *
 * <p>這種類型的設計模式屬於創建型模式，它提供了一種創建物件的最佳方式。
 *
 * <p>這種模式涉及一個單一的類，該類負責創建自己的對象，
 *
 * <p>同時確保只有單一對像被創建。 這個類別提供了一種訪問其唯一的物件的方式，可以直接訪問，不需要實例化該類別的物件。
 *
 * <p>單例模式是一種創建型設計模式，它確保一個類別只有一個實例，並提供了一個全域存取點來存取該實例。
 *
 * <p>注意：
 *
 * <p>1、單例類別只能有一個實例。 2、單例類別必須自己創建自己的唯一實例。 3、單例類別必須給所有其他物件提供此實例。
 *
 * <p>意圖：保證一個類別只有一個實例，並提供一個存取它的全域存取點。
 *
 * <p>主要解決：一個全域使用的類別頻繁地創建與銷毀。
 *
 * <p>何時使用：當您想要控制實例數目，節省系統資源的時候。
 *
 * <p>如何解決：判斷系統是否已經有這個單例，如果有則返回，如果沒有則創建。
 *
 * <p>關鍵程式碼：建構函數是私有的。
 */

/** Singleton Demo 1 : Hungry (餓漢式) */

// https://www.runoob.com/design-pattern/singleton-pattern.html

class MyClass {

  // attr
  private static final MyClass instance = new MyClass();

  // constructor
  // below is WRONG
  //    private MyClass(){
  //        //return MyClass;
  //        this.instance = new MyClass();
  //    }

  // NOTE !!! we ONLY make no arg constructor, that's it.
  //          so class CAN'T be init by other class
  //          the only way to get class instance
  //          is via getInstance() method, and make sure
  //          there is ALWAYS 1 instance
  private MyClass() {}

  public static MyClass getInstance() {
    if (instance == null) {
      return new MyClass();
    }
    return instance;
  }
}

public class Hungry {

  public static void main(String[] args) {

    MyClass myClass1 = MyClass.getInstance();
    MyClass myClass2 = MyClass.getInstance();
    System.out.println(myClass1 == myClass2); // true
  }
}
