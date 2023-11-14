package Queues;

import java.util.EmptyStackException;

public class Queue<K> {

    Node head;
    Node tail;

    private class Node {
        K item;
        Node next;

        private Node(K item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public Queue() {
    }

    // Class independent add method
    public void add(K item) {
        if (head == null) {
            head = new Node(item, null);
            tail = head;
        } else {
            Node node = new Node(item, null);
            tail.next = node;
            tail = node;
        }
    }

    /*
    // Improved add that utilize tail pointer
    public void add(Integer item) {
        if (head == null) {
            head = new Node(item, null);
            tail = head;
        } else {
            Node node = new Node(item, null);
            tail.next = node;
            tail = node;
        }
    }
     */

    /*
    public void add(Integer item) {
        if (head == null) {
            head = new Node(item, null);
        } else {
            Node node = new Node(item, null);
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }
    }
     */

    // Class independent remove
    public K remove() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            Node tmp = head;

            head = head.next;

            if (head == null){
                tail = null;
            }

            return tmp.item;
        }
    }

    /*
    public Integer remove() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            Node tmp = head;

            head = head.next;

            if (head == null){
                tail = null;
            }

            return tmp.item;
        }
    }
     */

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
}