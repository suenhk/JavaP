package com.suen.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Suen on 2018/2/20.
 */
public class Tree {
    class Node{
        Node left;
        Node right;
        Integer value;
        public Node(Integer value) {
            this.value = value;
        }
    }

    private Queue<Node> queue = new LinkedList<Node>();
    private boolean flag = false;

    public boolean isBTree(Node node){
        if (node==null){
            return false;
        }else{
            queue.offer(node);
            while(!queue.isEmpty()){
                node = queue.poll();

                if (flag){
                    if (node.left!=null || node.right!=null){
                        return false;
                    }
                }else{
                    if (node.left==null && node.right!=null){
                        return false;
                    }else if (node.left!=null && node.right==null){
                        queue.offer(node.left);
                        flag = true;
                    }else if (node.left!=null && node.right!=null){
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }else{
                        flag = true;
                    }
                }

            }

            return false;
        }

    }

    //借助队列，而不是栈
    public void cengci(Node node){

        ArrayDeque<Node> ad = new ArrayDeque<>();
        if (node!=null){
            ad.offer(node);
            while (!ad.isEmpty()){
                Node n = ad.poll();
                System.out.println(n.value);
                if (n.left!=null){
                    ad.offer(n.left);
                }
                if (n.right!=null){
                    ad.offer(n.right);
                }
            }
        }

    }

    public void pre(Node node){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        while (node!=null || !ad.isEmpty()){
            while (node!=null){
                System.out.println(node.value);
                ad.push(node);
                node = node.left;
            }
            if (!ad.isEmpty()){
                node = ad.pop();
                node = node.right;
            }
        }
    }

    public void mid(Node node){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        while (node!=null || !ad.isEmpty()){
            while (node!=null){
                ad.push(node);
                node = node.left;
            }
            if (!ad.isEmpty()){
                node = ad.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    public void last(Node node){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        while (node!=null || !ad.isEmpty()){
            while (node!=null){
                ad.push(node);
                node = node.left;
            }
            if (!ad.isEmpty()){
                node = ad.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }


    public static void main(String[] args){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (j==3){
                    break;
                }else{
                    System.out.println(j);
                }
            }
            System.out.println("----------------"+i);
        }
    }

}

