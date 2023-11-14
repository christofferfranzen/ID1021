package Heap;

public class ListPriorityQueue2 implements Queue{

    Node head;

    public class Node {
        int priority;
        Node next;

        Node(int priority) {
            this.priority = priority;
        }
    }

    public ListPriorityQueue2() {
    }

    // Add item with a given priority to the queue
    public void enqueue(int priority) {
        if (this.isEmpty()) {
            head = new Node(priority);
        } else {
            add(new Node(priority));
        }
    }

    // add method with a time complexity of O(n)
    private void add(Node node) {
        if (node.priority <= head.priority) {
            node.next = head;
            head = node;
        } else {
            Node current = head;

            // Traverse the list until we find a node with a higher priority or reach the end of the list
            while (current.next != null && current.next.priority < node.priority) {
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
        }
    }

    // Remove item with the highest priority.
    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("\nQueue is empty");
        }
        return remove();
    }

    // remove method with a time complexity of O(1)
    private int remove() {
        int tmp = head.priority;
        head = head.next;
        return tmp;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;

        return false;
    }
}
