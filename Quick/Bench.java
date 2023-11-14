package Quick;

import Queues.Queue;

import java.util.Arrays;
import java.util.Random;

public class Bench {

    public static Random rnd = new Random();

    public static void main(String[] args) {

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000};

        System.out.println("# Quick sort performed on data set of n, time in ns");
        System.out.println("n time \tArray \tLinkedList");


        for (int n : sizes) {

            int[] array = new int[n];
            LinkedList list = new LinkedList(n);

            // Populate the list with random numbers
            for (int i = 0; i < n; i++){
                array[i] = rnd.nextInt(n);
            }

            System.out.printf("%8d ", n);

            int k = 100;

            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                int[] clone = array.clone();
                long t0 = System.nanoTime();
                Array.sort(clone, 0, array.length-1);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

            }

            //System.out.printf("%8.0f\t", (min));
            System.out.printf("%8.0f\t", (min)/n);


            min = Double.POSITIVE_INFINITY;

            // Warm up

            for (int i = 0; i < k; i++) {
                LinkedList clone = list.clone();
                long t0 = System.nanoTime();
                LinkedList.sort(clone);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            //System.out.printf("%8.0f\n", (min));
            System.out.printf("%8.0f\n", (min)/n);


        }



        /*


        LinkedList list = new LinkedList();

        //LinkedList list = new LinkedList();

        list.add(10);
        list.add(22);
        list.add(44);
        list.add(33);
        list.add(77);
        list.add(11);
        list.add(44);

        list.print();

        //list.sort();
        LinkedList.sort(list);

        list.print();

         */


        /*
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(10);
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println("---");

        Array.sort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
         */
    }
}
