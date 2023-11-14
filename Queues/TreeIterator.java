package Queues;

import Trees.BinaryTree;

import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private Queue<BinaryTree.Node> queue;

    public TreeIterator(BinaryTree.Node root) {
        this.queue = new Queue<>();
        if (root != null) {
            this.queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        BinaryTree.Node node = queue.remove();
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
        return node.value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

