package LinkedList;

import org.w3c.dom.Node;

import java.sql.SQLOutput;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value) ;
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
        }
        if (index == size) {
            insertLast(value);
        }
        Node temp = head;
        for (int i=1;i<index;i++) {
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value +" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size --;
        return val;
    }

    public int deleteLast() {
        if(size <= 1) {
            deleteFirst();
        }
        Node secondLast = getNode(size-1);
        int value = tail.value;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return value;
    }

    public Node getNode(int index) {
        Node temp = head;
        for (int i=0;i<index;i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int delete(int index) {
        if(index == 0) {
            deleteFirst();
        }
        if(index == size-1) {
            deleteLast();
        }
        Node previous = getNode(index-1);
        int val = previous.next.value;
        previous.next = previous.next.next;
        size--;
        return val;

    }
    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if(temp.value == value) {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}
