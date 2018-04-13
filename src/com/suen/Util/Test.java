package com.suen.Util;

import java.util.*;

public class Test {

    public static void listSort(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(3);
        list.add(25);

        Collections.reverse(list);
            for (Integer i : list){
                System.out.println(i);
            }

        System.out.println("------------------------------");
        Collections.sort(list, Collections.reverseOrder());
        for (Integer i : list){
            System.out.println(i);
        }

    }

    public static void mapSort(){
        Map<String, Integer> map = new HashMap<>();
        map.put("cc",5);
        map.put("aa",10);
        map.put("bb",2);
        map.put("ee",7);
        map.put("dd",6);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList(set);
        Collections.sort(list,  new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue())
                    return -1;
                else if (o1.getValue() > o2.getValue())
                    return 1;
                return 0;
            }
        });
        for (Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }
    }

    public static void main(String[] args){
        mapSort();
    }

}
