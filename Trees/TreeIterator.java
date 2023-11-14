package Trees;

import java.util.Iterator;
import java.util.Stack; // TODO: Implement own Stack class

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private Stack<BinaryTree.Node> stack;

    public TreeIterator(BinaryTree.Node root) {
        next = root;

        stack = new Stack<>();
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        BinaryTree.Node node = stack.pop();
        Integer result = node.value;

        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
