package com.suen;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Suen on 2018/2/20.
 */
public class Cache {
    private Deque<String> queue = new LinkedList<String>();
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private int N = 3;

    public void put(String key, Integer value){
        if (queue.contains(key)){
            queue.remove(key);
        }
        queue.offerLast(key);
        if (queue.size()>N){
            String k = queue.getFirst();
            queue.removeFirst();
            map.remove(k);
        }
        map.put(key,value);
    }

    public Integer get(String key){
        Integer value = null;
        if (queue.contains(key)){
            queue.remove(key);
        }
        queue.offerLast(key);
        value = map.get(key);
        return value;
    }

    public static void main(String[] args){
        Cache cache = new Cache();
        Map<String, Integer> map = new HashMap();
        System.out.println(map.get("aa"));

        List<String> list = new LinkedList();
        list.add("aa");
        list.add("cc");
        list.add("123");
        list.add("bb");

//        for (String s : list){
//            System.out.println(s);
//        }

        cache.put("a",1);
        cache.put("d",2);
        cache.put("c",3);
        cache.get("a");
        cache.put("b",4);

        System.out.println(cache.get("a"));


    }
}
