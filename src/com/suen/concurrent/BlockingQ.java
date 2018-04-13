package com.suen.concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQ {

    private Object obj = new Object();
    private int num = 5;
    private Queue<String> queue = new LinkedList();

    public void set(){

        synchronized (obj){
            if (queue.size()==num){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                queue.add("a");
            }
        }

    }

    public String get(){
        synchronized (obj){
            if (queue.size()<=0){
                obj.notify();
                return null;
            }else{
                return queue.poll();
            }
        }

    }

}
