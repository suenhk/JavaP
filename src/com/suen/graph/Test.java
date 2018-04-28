package com.suen.graph;

import java.util.*;

public class Test {

    private int[] book = new int[5];
    private int min=999999;
    private int n=4;
    private List<Node> q = new ArrayList<Node>();
    private int head=0;
    private int tail=1;
    private boolean flag = false;

    public static void main(String[] args){
        int[][] a = {{0,2,999999,999999,10},
                {999999,0,3,999999,7},
                {4,999999,0,4,999999},
                {999999,999999,999999,0,5},
                {999999,999999,3,999999,0}};

        int[][] b = {{0,1,1,0,0},
                {1,0,1,1,0},
                {1,1,0,1,1},
                {0,1,1,0,1},
                {0,0,1,1,0}};

        Test t = new Test();
//        t.dfs(0, 0, a);
//        System.out.println(t.min);
        t.bfs(0,b);
        System.out.println(t.q.get(t.tail-1).step+"  "+t.q.get(t.tail-1).value);
    }

    public void dfs(int cur, int dis, int[][] a){
        if (dis>min){
            return;
        }
        if (cur==n){
            if (dis<min){
                min = dis;
            }
            return;
        }
        for (int i=0; i<5; i++){
            if (a[cur][i]!=-1 && book[i]==0){
                book[i] = 1;
                dfs(i,dis+a[cur][i],a);
                book[i] = 0;
            }
        }
        return;
    }

    public void bfs(int cur, int[][] b){
        q.add(new Node(cur,0));
        while (head < tail){
            for (int i=1; i<5; i++){
                cur = q.get(head).value;
                if (b[cur][i]!=0 && book[i]==0){
                    q.add(new Node(i, q.get(head).step+1));
                    tail++;
                    book[i] = 1;
                }
                if (q.get(tail-1).value == n){
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            head++;
        }
    }

}

class Node{
    int value;
    int step;
    public Node(int value, int step){
        this.value = value;
        this.step = step;
    }
}
