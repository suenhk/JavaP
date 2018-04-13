package com.suen.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Qiangdan implements Runnable {

    private static volatile LongAdder la = new LongAdder();
    private volatile AtomicInteger ai = new AtomicInteger(35);

    public static void main(String[] args){
        Qiangdan qd = new Qiangdan();
        new Thread(qd, "t----1").start();
        new Thread(qd, "t----2").start();
        new Thread(qd, "t----3").start();
        new Thread(qd, "t----4").start();
    }

    public void run(){
        while (ai.get()>0){
            System.out.println(Thread.currentThread().getName()+"     "+ai.getAndDecrement());
        }
    }

}
