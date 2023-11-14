package Heap;

public class LinkedHeap implements Queue {
    private Node root;

    private class Node{
        int priority;
        int elements;
        Node left, right;

        public Node(int priority){
            this.priority = priority;
            elements = 0;
        }
    }

    public void enqueue(int priority) {
        if (this.isEmpty()) {
            root = new Node(priority);
        } else {
            add(root, new Node(priority));
        }
    }

    private Node add(Node current, Node node) {
        current.elements++;

        if (node.priority < current.priority) {
            swap(current, node);
        }

        if (current.left == null) {
            current.left = node;
        } else if (current.right == null) {
            current.right = node;
        } else {
            if (current.left.elements <= current.right.elements) {
                add(current.left, node);
            } else {
                add(current.right, node);
            }
        }

        return current;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int priority = root.priority;

        if (root.left == null && root.right == null) {
            root = null;
        } else {
            root = remove(root);
        }

        return priority;
    }

    private Node remove(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            swapPriority(root);

            if (root.right.priority < root.left.priority) {
                root.right = remove(root.right);
            } else {
                root.left = remove(root.left);
            }

            root.elements--;
            return root;
        }
    }

    public int push(int incr) {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Increment the root's priority.
        root.priority += incr;

        return pushDown(root, 0);
    }

    private int pushDown(Node current, int depth) {
        // Continue pushing down the tree while there are child nodes.
        while (current.left != null || current.right != null) {
            Node left = current.left;
            Node right = current.right;
            Node minChild;

            // Determine the child node with the smallest priority.
            if (left == null || (right != null && right.priority < left.priority)) {
                minChild = right;
            } else {
                minChild = left;
            }

            // If the current node's priority is greater than the smallest child's priority, swap values.
            if (current.priority > minChild.priority) {
                int temp = current.priority;
                current.priority = minChild.priority;
                minChild.priority = temp;

                int tempElements = current.elements;
                current.elements = minChild.elements;
                minChild.elements = tempElements;

                current = minChild;
                depth++;
            } else {
                break;
            }
        }

        return depth;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void swap(Node a, Node b) {
        int tempPriority = a.priority;
        a.priority = b.priority;
        b.priority = tempPriority;
    }

    private void swapPriority(Node node) {
        int tempPriority = node.priority;
        node.priority = Math.min(node.left.priority, node.right.priority);
    }
}