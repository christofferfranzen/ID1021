package Sorting;

import java.util.Arrays;
import java.util.Random;

public class Bench {
    public static void main(String[] args) {
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};
        //int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800};

        int k = 1000;
        int loop = 10000;

        System.out.printf("# sorting through an unsorted array of length n, time in ns\n");
        System.out.println("n time \tSelection \tInsertion \tMerge \tQuick");

        for (int n : sizes) {
            // Selection sort benchmark
            System.out.printf("%8d ", n);

            double min = Double.POSITIVE_INFINITY;

            int[] array1 = random(n);

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                int[] clone = array1.clone();
                Selection.sort(clone);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.print(min/loop + " : ");


            // Insertion sort
            min = Double.POSITIVE_INFINITY;

            int[] array2 = random(n);

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                int[] clone = array2.clone();
                Insertion.sort(clone);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.print(min/loop + " : ");

            // Merge sort
            min = Double.POSITIVE_INFINITY;

            int[] array3 = random(n);

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                int[] clone = array3.clone();
                Merge.sort(clone);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.print(min/loop + " : ");

            // Quick sort
            min = Double.POSITIVE_INFINITY;

            int[] array4 = random(n);

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                int[] clone = array4.clone();
                Quick.sort(clone, 0, clone.length-18);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.println(min/loop);
        }
    }

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] index = new int[loop];
        for (int i = 0; i < loop ; i++) {
            index[i] = rnd.nextInt(n*5);
        }
        return index;
    }

    private static int[] random(int length){
        Random rnd = new Random();

        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = rnd.nextInt(1000)+1;
        }

        return array;
    }
}
