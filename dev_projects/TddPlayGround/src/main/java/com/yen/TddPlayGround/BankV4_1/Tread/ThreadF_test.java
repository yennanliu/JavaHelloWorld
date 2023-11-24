//package com.yen.TddPlayGround.BankV4_1.Tread;
//
//import com.yen.TddPlayGround.BankV4_1.bean.User;
//import com.yen.TddPlayGround.BankV4_1.service.BaseBankService;
//
//public class ThreadF_test {
//
//    // attr
//    private BaseBankService bank;
//    private User user;
//
//    private double amount;
//
//    private ThreadFactory thread;
//
//    // constructor
//    public ThreadF_test(BaseBankService bank, User user, double amount, ThreadFactory thread){
//        this.bank = bank;
//        this.user = user;
//        this.amount = amount;
//        this.thread = thread;
//    }
//
//    public void run(){
//        if (this.thread.getClass().getName().equals("ThreadDeposit")){
//
//            // run ThreadDeposit logic
//            try {
//                this.bank.deposit(this.user, this.amount);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        } else if (this.thread.getClass().getName().equals("ThreadGetBalance")) {
//
//            // run ThreadGetBalance logic
//            try{
//                this.bank.getBalance(user);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }else if (this.thread.getClass().getName().equals("ThreadWithdraw")){
//
//            /// run ThreadWithdraw logic
//            try {
//                this.bank.withdraw(this.user, this.amount);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }else {
//            System.out.println("No such tread type : " + this.thread);
//        }
//    }
//
//
//}
