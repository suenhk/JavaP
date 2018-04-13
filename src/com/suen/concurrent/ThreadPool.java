package com.suen.concurrent;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    static Queue<MyThread> idelQ = new LinkedBlockingQueue<>();

    public void startPool(int num){
        for (int i=0; i<num; i++){
            MyThread thread = new MyThread(){
                public void run(){

                }
            };
            thread.start();
            idelQ.offer(thread);
        }
    }

    public void setTarget(Thread thread){
        if (idelQ.size()>0){
            MyThread myThread = idelQ.poll();
            myThread.setThread(thread);

        }
    }

    public static void repool(MyThread thread){
        idelQ.offer(thread);

    }

    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                System.out.println("hello");

            }
        };
        System.out.println(Integer.MAX_VALUE);


    }

}

class MyThread extends Thread{

    private Runnable thread;
    private boolean shutDown = false;
    private boolean sync = false;

    public void setThread(Thread thread){
        this.thread = thread;
        notify();
    }

    public void run(){
        while (!shutDown){
            if (thread!=null){
                thread.run();
            }

            ThreadPool.repool(this);
            synchronized (this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
