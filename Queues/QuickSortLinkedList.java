package Queues;

public class QuickSortLinkedList {
    static class Node {
        int data;
        Node next;
        Node (int d) {
            this.data = d;
            this.next = null;
        }
    }
    Node head;
    void addNode (int data) {
        if (head == null) {
            head = new Node (data);
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        Node newNode = new Node (data);
        curr.next = newNode;
    }
    void printList (Node n) {
        while (n != null) {
            System.out.print (n.data);
            System.out.print (" ");
            n = n.next;
        }
    }
    Node partitionLast (Node start, Node end) {
        if (start == end || start == null || end == null) return start;
        Node pivot_prev = start;
        int pivot = end.data;
        while (start != end) {
            if (start.data < pivot) {
                int temp = pivot_prev.data;
                pivot_prev.data = start.data;
                start.data = temp;
                pivot_prev = pivot_prev.next;
            }
            start = start.next;
        }
        int temp = pivot_prev.data;
        pivot_prev.data = pivot;
        end.data = temp;
        return pivot_prev;
    }
    void sort (Node start, Node end) {
        if(start == null || start == end|| start == end.next ) return;
        Node pivot_prev = partitionLast (start, end);
        sort (start, pivot_prev);
        if( pivot_prev != null && pivot_prev.next != null)
            sort (pivot_prev.next.next, end);
    }
    public static void main (String [] args) {
        QuickSortLinkedList list = new QuickSortLinkedList ();
        list.addNode (30);
        list.addNode (3);
        list.addNode (4);
        list.addNode (20);
        list.addNode (5);

        Node n = list.head;
        while (n.next != null) n = n.next;

        System.out.println ("Linked List before sorting");
        list.printList(list.head);

        list.sort(list.head, n);

        System.out.println ("Linked List after sorting");
        list.printList(list.head);
    }
}
