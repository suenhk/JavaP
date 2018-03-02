package com.suen.list;

/**
 * Created by Suen on 2018/3/1.
 */
public class FindK {
    //查找链表倒数第K个节点
    public static int find(Node head, int num){
        int t = num;
        Node cur = head;
        while (num>0){
            cur = cur.next;
            num--;
        }
        while(cur!=null){
            cur = cur.next;
            head = head.next;
        }
        return head.value;
    }

    class Node{
        Node next;
        int value;
    }
}
