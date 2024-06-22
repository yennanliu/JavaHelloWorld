package Advances.Optional;

// https://www.youtube.com/watch?v=MYXoEU3RkG0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684
// https://www.youtube.com/watch?v=wOi2k4dJviM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional demo 1
 *
 * <p>-> for avoiding "Null pointer" exception in development -> use methods -> 1) ofNullable(T t)
 * -> 2) orElse(T t)
 *
 * <p>1) Optional.of(T t) : return an optional instance, t NEEDS to be not null 2) Optional.empty()
 * : return a null Optional instance 3) Optional.ofNullable(T t) : t can be null
 */
public class demo1 {

  @Test
  public void test1() {
    Girl girl = new Girl();
    // wrong, if use Optional.of(T t), girl CAN NOT BE null
    // girl = null;
    Optional<Girl> optionalGirl = Optional.of(girl);
    System.out.println(">>> optionalGirl = " + optionalGirl);
  }

  @Test
  public void test2() {
    Girl girl = new Girl();
    // OK, if use Optional.ofNullable(T t), girl CAN BE null
    girl = null;
    Optional<Girl> optionalGirl = Optional.ofNullable(girl);
    System.out.println(">>> optionalGirl = " + optionalGirl);
  }

  @Test
  public void test2_1() {
    Girl girl = new Girl();
    // girl = null;
    Optional<Girl> optionalGirl = Optional.ofNullable(girl);

    /**
     * orElse :
     *
     * <p>-> if t in Optional is not null, then return its t -> else, return t1 in orElse()
     */
    Girl girl1 = optionalGirl.orElse(new Girl("Lynn"));

    System.out.println(">>> optionalGirl = " + optionalGirl);
    System.out.println(">>> girl1 = " + girl1);
  }

  @Test
  public void test3() {
    Boy boy = new Boy(new Girl("Ann"));
    //        String girlName = getGirlName(boy);
    //        System.out.println(">>> girlName = " + girlName);

    String girlName2 = getGirlNameV2(boy);
    System.out.println(">>> girlName2 = " + girlName2);

    String girlName3 = getGirlNameV3(boy);
    System.out.println(">>> girlName3 = " + girlName3);
  }

  // method
  public String getGirlName(Boy boy) {
    // may have "java.lang.NullPointerException" exception
    return boy.getGirl().getName();
  }

  // optimize via if else
  public String getGirlNameV2(Boy boy) {
    Girl girl = boy.getGirl();
    if (girl != null) {
      return boy.getGirl().getName();
    } else {
      return null;
    }
  }

  // optimize via Optional
  public String getGirlNameV3(Boy boy) {

    // handle if boy is null case
    Optional<Boy> boyOptional = Optional.ofNullable(boy);

    Boy boy1 = boyOptional.orElse(new Boy(new Girl("Ann")));

    Girl girl = boy1.getGirl();

    Optional<Girl> girlOptional = Optional.ofNullable(girl);

    Girl girl1 = girlOptional.orElse(new Girl("emily"));

    return girl1.getName();
  }
}
