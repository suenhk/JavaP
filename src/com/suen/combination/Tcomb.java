package com.suen.combination;

import java.util.Arrays;

public class Tcomb {
    public static void main(String[] args){
//        System.out.println(fac(5));
//        System.out.println(combination(7,3));
//        System.out.println(arrangement(7,3));
        String[] a = {"a","b","c","d","e"};
        int[] c = new int[6];
//        b[4] = "5";
//        System.out.println(b[0]);
        int count = 0;
        as(7, 3, c,count);
        System.out.println("count"+count);
    }

    public static int fac(int n){
        if (n>1){
            if (n==1){
                return 1;
            }else{
                return n*fac(n-1);
            }
        }else{
            return 1;
        }
    }

    public static int combination(int n, int m){
        if (n>=m){
            return fac(n)/(fac(m)*fac(n-m));
        }else{
            return -1;
        }
    }

    public static void as(int n, int m, int[] c, int count){
        for (int i=n; i>=m; i--){
            c[m] = i;
            if (m>1){
                as(i-1, m-1, c, count);
            }else{
                for (int j=1; j<=3; j++){
                    System.out.print(c[j]+",");
                }
                count++;
                System.out.println();
            }
        }
    }

    public static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex + 1);
            }
        }
    }

    public static int arrangement(int n, int m){
        if (n>=m){
            return fac(n)/fac(n-m);
        }else{
            return -1;
        }
    }
}
