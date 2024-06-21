package com.yen.atguigu.lock.course18;

import java.util.concurrent.TimeUnit;

// Course 18 : https://youtu.be/yISksGq85yc?si=hWJQgPDa6Oc06Ixq

class Phone {

  public static synchronized void sendSMS() throws Exception {
    // 停留4秒
    TimeUnit.SECONDS.sleep(4);
    System.out.println("------sendSMS");
  }

  public synchronized void sendEmail() throws Exception {
    System.out.println("------sendEmail");
  }

  public void getHello() {
    System.out.println("------getHello");
  }
}

/**
 * @Description: 8锁
 *
 * <p>1 标准访问，先打印短信还是邮件 ------sendSMS ------sendEmail
 *
 * <p>2 停4秒在短信方法内，先打印短信还是邮件 ------sendSMS ------sendEmail
 *
 * <p>3 新增普通的hello方法，是先打短信还是hello ------getHello ------sendSMS
 *
 * <p>4 现在有两部手机，先打印短信还是邮件 ------sendEmail ------sendSMS
 *
 * <p>5 两个静态同步方法，1部手机，先打印短信还是邮件 ------sendSMS ------sendEmail
 *
 * <p>6 两个静态同步方法，2部手机，先打印短信还是邮件 ------sendSMS ------sendEmail
 *
 * <p>7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件 ------sendEmail ------sendSMS
 *
 * <p>8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件 ------sendEmail ------sendSMS
 */
public class Lock_8 {
  public static void main(String[] args) throws Exception {

    Phone phone = new Phone();
    Phone phone2 = new Phone();

    new Thread(
            () -> {
              try {
                Phone.sendSMS();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "AA")
        .start();

    Thread.sleep(100);

    new Thread(
            () -> {
              try {
                // phone.sendEmail();
                // phone.getHello();
                phone2.sendEmail();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "BB")
        .start();
  }
}
