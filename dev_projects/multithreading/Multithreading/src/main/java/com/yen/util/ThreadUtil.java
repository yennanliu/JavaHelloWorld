package com.yen.util;

public class ThreadUtil {

    public Thread createRunnableThread(String name, Runnable runnable){

        return new Thread(runnable, name);
    }

}
