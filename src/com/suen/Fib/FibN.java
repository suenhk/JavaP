package com.suen.Fib;

/**
 * Created by Suen on 2018/3/1.
 */
public class FibN {
    public static int fib_recursion(int num){
        if (num==2 || num==1){
            return 1;
        }else{
            return fib_recursion(num-1)+fib_recursion(num-2);
        }
    }
    public static int fib(int n){

        if (n==2 || n==1){
            return 1;
        }else{
            int p=1,q=1,t;
            for (int i=3; i<=n; i++){
                t = p;
                p = p+q;
                q = t;
            }
            return p;
        }
    }
}
