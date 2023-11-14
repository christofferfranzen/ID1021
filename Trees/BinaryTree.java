package Trees;

import java.util.*;

public class BinaryTree implements Iterable<Integer> {
    public Node root;
    boolean queue;

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if (left != null)
                left.print();

            System.out.println(" key: " + key + "\tvalue: " + value);

            if (right != null)
                right.print();
        }
    }

    public BinaryTree() {
        root = null;
        this.queue = false;
    }

    public BinaryTree(boolean queue) {
        root = null;
        this.queue = queue;
    }

    /**
     * Adds a new node (leaf) to the
     * tree that maps the key to the value. If the key is already present we
     * update the value of the node. Note that the tree should still be sorted.
     */
    public void add(Integer key, Integer value) {
        root = addRecursive(root, key, value);
    }

    private Node addRecursive(Node current, Integer key, Integer value) {
        if (current == null) {
            return new Node(key, value);
        }

        if (key < current.key) {
            current.left = addRecursive(current.left, key, value);
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key, value);
        } else {
            current.value = value; // Value already exists
            return current;
        }

        return current;
    }

    /* TODO: Implement delete method
    public void delete(Integer key) {
        if (root == null) {
            return;
        }

        root = root.delete(key);
    }

     */

    /**
     * Find and return the value associate to the
     * key. If the key is not found we return null.
     *
     * @noinspection WeakerAccess
     */
    public Integer lookup(Integer key) {
        return lookupRecursive(root, key);
    }

    private Integer lookupRecursive(Node current, Integer key) {
        if (current == null) {
            throw new EmptyStackException();
        }

        if (key.equals(current.key)) {
            return current.value; // Returns the value of the key
        }

        if (key < current.key) {
            return lookupRecursive(current.left, key);
        } else {
            return lookupRecursive(current.right, key);
        }
    }

    public void saturateSelf(int k, int n) {
        int insert = (n + k) / 2;
        if (insert == k || insert == n) {
            return;
        }

        add(insert, insert);
        saturateSelf(k, insert);
        saturateSelf(insert, n);
    }

    public Integer deepestNode() {
        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node result = null;
        while(!queue.isEmpty()) {
            result = queue.poll();
            if(result.left != null)
                queue.add(result.left);
            if(result.right != null)
                queue.add(result.right);
        }
        return result.key;
    }


        @Override
        public Iterator<Integer> iterator () {
            if (queue == true){
                return new Queues.TreeIterator(root);
            }
            return new TreeIterator(root);
        }
    }
