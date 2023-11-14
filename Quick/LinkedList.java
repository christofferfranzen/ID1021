package Quick;

import java.util.Random;

public class LinkedList {
    Node head;
    Node tail;

    public static Random rnd = new Random();

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList(int length){
        Node last = null;
        for (int i = 0; i < length; i++) {
            last = new Node(rnd.nextInt(length), last);
        }
        head = last;
    }

    public LinkedList clone(){
        LinkedList newList = new LinkedList(0);
        Node current = this.head;
        while(current != null){
            newList.add(current.value);
            current = current.next;
        }
        return newList;
    }

    public void add(int value){
        if (head == null){
            head = new Node(value, null);
            tail = head;
        }
        else {
            Node newCell = new Node(value, null);
            Node tmp = tail;
            tmp.next = newCell;
            tail = newCell;
        }
    }

    public void print() {
        System.out.print("  [");
        Node cur = this.head;
        if (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
        }
        while (cur != null) {
            System.out.print(", " + cur.value);
            cur = cur.next;
        }
        System.out.println("]");
    }

    // Return the length of the sequence.
    public int length(){
        int count = 0;

        if (head == null){
            return count;
        }
        else {
            Node last = head;

            while (last.next != null){
                last = last.next;
                count++;
            }

            count++;
        }
        return count;
    }

    public static LinkedList sort(LinkedList list) {
        list.head = quickSort(list.head);
        Node temp = list.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        list.tail = temp;

        return list;
    }

    private static Node quickSort(Node node) {
        // If the list is empty or has only one element, it is sorted
        if (node == null || node.next == null) {
            return node;
        }

        // Choose>Bthe first element as pivot
        Node pivot = node;

        // Create two lists for elements smaller and larger than pivot
        Node left = new Node(0, null), right = new Node(0, null);

        // Initialize pointers for these lists
        Node leftPtr = left, rightPtr = right, headPtr = node.next;

        // Partition the list into two halves around the pivot
        while (headPtr != null) {
            if (headPtr.value < pivot.value) {
                leftPtr.next = headPtr;
                leftPtr = headPtr;
            } else {
                rightPtr.next = headPtr;
                rightPtr = headPtr;
            }
            headPtr = headPtr.next;
        }

        // Terminate the lists
        leftPtr.next = null;
        rightPtr.next = null;

        // Recursively sort the two halves
        left.next = quickSort(left.next);
        right.next = quickSort(right.next);

        // Combine the sorted halves and pivot into one sorted list
        getTail(left).next = pivot;
        pivot.next = right.next;

        return left.next;
    }

    private static Node getTail(Node node) {
        // Helper function to get the tail of a list
        if (node == null || node.next == null) {
            return node;
        }

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }
}