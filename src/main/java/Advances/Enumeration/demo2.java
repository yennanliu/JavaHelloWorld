package Advances.Enumeration;

// https://www.youtube.com/watch?v=Um-n9ecN898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=498

/**
 *  Enumeration (枚舉類) demo 2 : via `enum` (after >= jdk 5.0 : use `enum` key word for Enumeration)
 *
 *   1) defined Enumeration (via `enum`) is ` class java.lang.Enum` 's subclass
 */

public class demo2 {
    public static void main(String[] args) {
        // test
        Season1 spring = Season1.SPRING;
        Season1 summer = Season1.SUMMER;
        Season1 autumn = Season1.AUTUMN;
        Season1 winter = Season1.WINTER;

        System.out.println(spring);
        System.out.println(summer);
        System.out.println(autumn);
        System.out.println(winter);

        System.out.println("==================");

        System.out.println(spring.getSeasonName());

        System.out.println("==================");

        System.out.println(Season1.class.getSuperclass()); // class java.lang.Enum

        System.out.println("==================");

        // common methods demo
        // ref : https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Enumeration/demo1.java

        // values
        Season1[] values = Season1.values();
        for (int i=0; i < values.length; i++){
            System.out.println(values[i]);
        }

        System.out.println("==================");

        // valueOf(String objName)
        // -> based on given objName, return obj in Enumeration which has same name as objName
        Season1 winter2 = Season1.valueOf("WINTER");
        System.out.println(winter2);

        System.out.println("==================");

        // toString()
        System.out.println(summer.toString());
    }
}


/** method 2) via `enum` (after >= jdk 5.0 : use `enum` key word for Enumeration) */
enum Season1{

    // step 1) offer multiple objects on current Enumeration
    // NOTE !!! if use `enum`, we need to follow below syntax
    // 1) within attr, use `,`
    // 2) user `;` after final attr
    // 3) DON'T use public static final, but only attr name and its args
    //    -> e.g. SPRING("spring", "warm season"),
    SPRING("spring", "warm season"),
    SUMMER("summer", "hot season"),
    AUTUMN("autumn", "medium season"),
    WINTER("winter", "cold season");


    // attr
    // step 2) declare Season object's attr, and make it private final
    private final String seasonName;
    private final String seasonDesc;

    // constructor
    // step 3) make constructor private, and give attr value
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // step 4) other requirement, e.g. get properties of Enumeration
    // getter
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // other methods
    // we don't need to override toString here,
    // -> since defined Enumeration (via `enum`) is ` class java.lang.Enum` 's subclass
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}