package Heap;

public class ListPriorityQueue implements Queue {

    Node head;

    public class Node {
        int priority;
        Node next;

        Node(int priority) {
            this.priority = priority;
        }
    }

    public ListPriorityQueue() {
    }

    // Add item with a given priority to the queue
    public void enqueue(int priority) {
        if (this.isEmpty()) {
            head = new Node(priority);
        } else {
            add(new Node(priority));
        }
    }

    // add method with a time complexity of O(1)
    private void add(Node node) {
        node.next = head;
        head = node;
    }

    // Remove item with the highest priority.
    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("\nQueue is empty");
        }
        return remove();
    }

    // remove time complexity of O(n) where n is the number of elements in the queue.
    private int remove() {
        Node min = head;
        Node minPrev = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.priority < min.priority) {
                min = current;
                minPrev = prev;
            }
            prev = current;
            current = current.next;
        }

        if (min == head) {
            head = head.next;
        } else {
            minPrev.next = min.next;
        }

        return min.priority;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;

        return false;
    }
}
