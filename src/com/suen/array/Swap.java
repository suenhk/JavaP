package com.suen.array;

import java.util.HashMap;
import java.util.Map;

public class Swap {

    public static void main(String[] args){

        int[] a = {2,2,2,0,2,5,5,3,0,0,1,1,9,5,1,1};
        String[] as = {"a","a","a","c","d","c","c","f","a","d","g"};
        test(as);
        for (String s : as){
            System.out.println(s);
        }

    }

    public static void test(String[] a){
        Map<String, Integer> map = new HashMap<>();
        String temp = "";
        for (int i=0; i<a.length; i++){
            if (i>0){
                if (!a[i].equals(a[i-1])){
                    while (!a[i].equals(a[i-1])){
                        Integer site = map.get(a[i]);
                        if (site!=null){
                            temp = a[site+1];
                            a[site+1] = a[i];
                            map.put(a[i], site+1);
                            a[i] = temp;
                            if (map.get(a[i])==site+1){
                                map.put(a[i], i);
                                break;
                            }

                        }else{
                            map.put(a[i], i);
                            break;
                        }
                    }
                }else{
                    map.put(a[i], i);
                }
            }else{
                map.put(a[i], i);
            }

        }
    }

}
