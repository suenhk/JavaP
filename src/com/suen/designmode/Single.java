package com.suen.designmode;

/**
 * Created by Suen on 2018/3/1.
 */

public enum Single {

    INSTANCE;

    private Single(){
        System.out.println("init...");
    }

    public String getData(){
        return "hello";
    }

    public static void main(String[] args){
        INSTANCE.getData();
    }

}
