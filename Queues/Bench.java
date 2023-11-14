package Queues;

public class Bench {
    public static void main(String[] args) {

        /*
        test<Integer> queue = new test<Integer>(1);

        queue.push(55);
        queue.push(33);
        queue.push(11);
        queue.push(88);
        queue.push(78);
        queue.push(79);
        queue.push(80);

        for (int i = 0; i < 8; i++){
            System.out.println(queue.pop());
        }
         */

        DynamicArrayQueue queue = new DynamicArrayQueue(2);

        queue.add(55);
        queue.add(33);
        queue.add(11);
        queue.add(88);
        queue.add(78);
        queue.add(79);
        queue.add(80);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        for (int i = 0; i < 7; i++){
            System.out.println(queue.remove());
        }

        /*
        Queue queue = new Queue();

        queue.add(55);
        queue.add(44);
        queue.add(11);
        queue.add(1);

        queue.remove();
        queue.remove();
        queue.add(99);
        queue.remove();
         */

        /*
        BinaryTree tree = new BinaryTree(true);

        tree.add(1, 101);
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(9, 109);
        tree.add(3, 103);
        tree.add(4, 104);
        tree.add(7, 107);
        tree.add(8, 108);

        for (int i : tree)
            System.out.println("next value " + i);
         */

    }
}
