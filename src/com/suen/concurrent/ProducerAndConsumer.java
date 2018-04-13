package com.suen.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
}

class Producer implements Runnable{

    BlockingQueue<String> bq = new LinkedBlockingQueue<>();
    volatile boolean running = true;

    public Producer(BlockingQueue bq){
        this.bq = bq;
    }

    public void run(){
        while(running){
            try {
                bq.put("aa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable{

    BlockingQueue<String> bq = new LinkedBlockingQueue<>();
    volatile boolean running = true;

    public Consumer(BlockingQueue bq){
        this.bq = bq;
    }

    public void run(){
        while (running){
            try {
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
