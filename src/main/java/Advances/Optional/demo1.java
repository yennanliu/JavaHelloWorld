package Advances.Optional;

// https://www.youtube.com/watch?v=MYXoEU3RkG0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684

import org.junit.jupiter.api.Test;

import java.util.Optional;


/**  Optional demo 1
 *
 *   1) Optional.of(T t) : return an optional instance, t NEEDS to be not null
 *   2) Optional.empty() : return a null Optional instance
 *   3) Optional.ofNullable(T t) : t can be null
 */

public class demo1 {

    @Test
    public void test1(){
        Girl girl = new Girl();
        // wrong, if use Optional.of(T t), girl CAN NOT BE null
        //girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(">>> optionalGirl = " + optionalGirl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        // OK, if use Optional.ofNullable(T t), girl CAN BE null
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(">>> optionalGirl = " + optionalGirl);
    }

}
