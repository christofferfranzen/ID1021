package Trees;

import java.util.*;

public class Bench {

    public static Random rnd = new Random();

    public static void main(String[] args) {

        /*

        //int[] sizes = {10, 100, 1000, 10000, 100000, 1000000};
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};
        //int[] sizes = {128, 256, 512, 1024, 2048, 4096};

        System.out.println("# lookup through an unsorted binary tree of length n, time in ns");

        for (int n : sizes) {

            System.out.printf("%8d ", n);

            BinaryTree tree = new BinaryTree();

            int k = 100;

            tree.saturateSelf(-1, n);

            double min = Double.POSITIVE_INFINITY;

            int[] keys = new int[1000];

            for (int i = 0; i < 1000; i++){
                keys[i] = rnd.nextInt(n);
            }

            double time = 0;

            for (int i = 0; i < k; i++) {

                long t0 = System.nanoTime();

                for (int j = 0; j < 1000; j++){
                    //tree.lookup(key);
                    tree.lookup(keys[j]);
                }

                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

                time += t;

            }

            //System.out.printf("%8.0f\n", (min));
            System.out.println(min);


        }

         */


        BinaryTree tree = new BinaryTree();

        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);

        for (int i : tree)
            System.out.println("next value " + i);

    }
}
