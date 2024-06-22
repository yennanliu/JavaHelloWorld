package Basics.ControllAccess_1;

// https://www.youtube.com/watch?v=dPgnPoFWkFY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=274

public class Order {

  public int orderPublic;
  protected int orderProtected;
  int orderDefault;
  // attr
  private int orderPrivate;

  // method
  // all attr are visible in the SAME CLASS (as attr)
  private void methodPrivate() {
    orderPrivate = 1;
    orderDefault = 2;
    orderProtected = 3;
    orderPublic = 4;
  }

  void methodDefault() {
    orderPrivate = 1;
    orderDefault = 2;
    orderProtected = 3;
    orderPublic = 4;
  }

  protected void methodProtected() {
    orderPrivate = 1;
    orderDefault = 2;
    orderProtected = 3;
    orderPublic = 4;
  }

  public void methodPublic() {
    orderPrivate = 1;
    orderDefault = 2;
    orderProtected = 3;
    orderPublic = 4;
  }
}
