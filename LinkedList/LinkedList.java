package LinkedList;

public class LinkedList {
    public Node head;
    public Node tail; // TODO: Implement tail pointer and make append use tail pointer

    public LinkedList(int n) {
        Node last = null;
        for (int i = 0; i < n; i++) {
            last = new Node(i, last);
        }
        head = last;
    }

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int val, Node t1) {
            data = val;
            next = t1;
        }

        public Node(int val) {
            data = val;
            next = null;
        }
    }

    // Add the item as the first cell in the sequence
    public void add(int item){
        // Create a new cell with given data
        Node node = new Node(item, null);

        if (head == null){
            head = node;
        }
        else {
            node.next = head;
            head = node;
        }
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

    // Return true or false depending on if the
    // item can be found in the sequence.
    public boolean find(int item){
        if (head == null){
            return false;
        }
        else {
            Node last = head;

            while (last.next != null){
                if (last.data == item){
                    return true;
                }

                last = last.next;
            }

            if (last.data == item){
                return true;
            }
        }
        return false;
    }

    // Remove the item if it exists in the sequence.
    public void remove(int item){
        if (head != null && head.data == item) {
            head = head.next;
            return;
        }

        Node last = head;

        while (last != null && last.next != null){
            if (last.next.data == item){
                last.next = last.next.next;
            } else {
                last = last.next;
            }
        }
    }

    // Append a sequence to the end
    // of a sequence
    public void append(LinkedList b) {
        if (head == null){
            head = b.head;
        }
        else {
            Node last = head;

            while (last.next != null){
                last = last.next;
            }

            last.next = b.head;
        }
    }

    // Remove a specific cell identified by a reference
    public void unlink(Node t1){
        if (head != null && head == t1) {
            head = head.next;
            return;
        }

        Node last = head;

        while (last != null && last.next != null){
            if (last.next == t1){
                last.next = last.next.next;
            } else {
                last = last.next;
            }
        }
    }

    // Insert a cell as the first cell in the list
    public void insert(Node t1){
        if (head == null){
            head = t1;
            t1.next = null;
        }
        else {
            t1.next = head;
            head = t1;
        }
    }

    public void print() {
        System.out.print("  [");
        Node cur = head;
        if (cur != null) {
            System.out.print(cur.data);
            cur = cur.next;
        }
        while (cur != null) {
            System.out.print(", " + cur.data);
            cur = cur.next;
        }
        System.out.println("]");
    }
}