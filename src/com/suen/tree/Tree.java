package com.suen.tree;

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

