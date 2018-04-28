package com.suen.array;

/**
 * Created by Suen on 2018/3/1.
 */
public class RemoveDul {

    public static int findRight(int[] a, int key){
        int right = a.length;
        int left = 0;
        int mid;
        while(left<right){
            mid = (left+right)/2;
            if (a[mid]>key){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return right;
    }

    public static int findLeft(int[] a, int key){
        int left = 0;
        int right = a.length;
        int mid;
        while (left<right){
            mid = (left+right)/2;
            if (a[mid]<key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] a = {1,2,2,3,3,3,3,4,4};
        System.out.println(findLeft(a,3));
        System.out.println(findRight(a,3));
    }

}
