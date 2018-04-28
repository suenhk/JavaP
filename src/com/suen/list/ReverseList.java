package com.suen.list;

public class ReverseList {

    public static Node reverse(Node head){
        if (head!=null){
            Node q = null;
            Node cur = head.next;
            Node p = head.next;
            while (p!=null){
                p = cur.next;
                cur.next = q;
                q = cur;
                cur = p;
            }
            head.next = q;
        }
        return null;
    }

    public static void main(String[] args){
        Node n4 = new Node(null, 4);
        Node n3 = new Node(n4, 3);
        Node n2 = new Node(n3, 2);
        Node n1 = new Node(n2, 1);
        Node head = new Node(n1, 0);
        System.out.println(head.value+":"+head.next.value+":"+head.next.next.value+":"+head.next.next.next.value+":"+head.next.next.next.next.value);
        reverse(head);
        System.out.println(head.value+":"+head.next.value+":"+head.next.next.value+":"+head.next.next.next.value+":"+head.next.next.next.next.value);

    }

    static class Node{
        Node next;
        int value;
        public Node(Node next, int value){
            this.next = next;
            this.value = value;
        }
    }

}
