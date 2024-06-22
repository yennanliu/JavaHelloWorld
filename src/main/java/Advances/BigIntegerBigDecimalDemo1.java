package Advances;

// https://www.youtube.com/watch?v=wkdjIp20MRs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=493

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerBigDecimalDemo1 {
  public static void main(String[] args) {
    BigInteger b1 = new BigInteger("342334234543543534534");
    BigDecimal bd1 = new BigDecimal("1223423.34534");
    BigDecimal bd2 = new BigDecimal("77");

    System.out.println(b1);
    System.out.println(bd1.divide(bd2, BigDecimal.ROUND_HALF_UP));
    System.out.println(bd1.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
  }
}
