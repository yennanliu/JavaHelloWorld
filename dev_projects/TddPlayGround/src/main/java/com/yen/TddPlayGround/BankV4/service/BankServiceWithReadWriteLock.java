package com.yen.TddPlayGround.BankV4.service;

import com.yen.TddPlayGround.BankV4.bean.User;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankServiceWithReadWriteLock implements BaseBankService{

    // attr
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public BankServiceWithReadWriteLock(){

    }

    // NOTE !!! since 讀讀互斥, there is ONLY 1 thread can write data on the same time (so still use synchronized for now)
    public synchronized void deposit(User user, double amount) throws InterruptedException {

        // add write lock
        rwLock.writeLock().lock();

        try{
            double curBalance = user.getBalance();
            user.setBalance(curBalance + amount);
            System.out.println("(after deposit) current balance : " + user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // release write lock
            rwLock.writeLock().unlock();
        }
    }

    // NOTE !!! since 讀讀互斥, there is ONLY 1 thread can write data on the same time (so still use synchronized for now)
    public synchronized void withdraw(User user, double amount) throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec

        double curBalance = user.getBalance();

        // add write lock
        rwLock.writeLock().lock();

        try{
            // TODO : check "虛假喚醒" (should use "while" instead of "if)
            if (curBalance >= amount){
                curBalance -= amount; // NOTE !! we update curBalance, so can reflect to while logic above (used by synchronized)
                user.setBalance(curBalance);
                System.out.println("(after withdraw) current balance : " + user);
                TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
            }
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }finally {

            // unlock write lock
            rwLock.writeLock().unlock();

            System.out.println("Not enough balance, sleep 3 sec ..." + user + " amount = " + amount);
            TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
        }
    }

    @Override
    public void getBalance(User user) {

        // add write lock
        rwLock.readLock().lock();

        try{
            System.out.println("balance = " + user.getBalance());
            TimeUnit.MILLISECONDS.sleep(200); // sleep 2 sec
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // unlock read lock
            rwLock.readLock().unlock();
        }
    }

}
