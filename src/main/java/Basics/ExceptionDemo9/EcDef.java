package Basics.ExceptionDemo9;

// https://www.youtube.com/watch?v=aMplVyvmwYE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=383

/**
 * User defined exception class
 *
 * <p>1) extend from Exception 2) define a serivalVersionUid
 */
public class EcDef extends Exception {
  static final long serialVersionUID = -300034534534L;

  public EcDef() {}

  public EcDef(String msg) {
    super(msg);
  }
}
