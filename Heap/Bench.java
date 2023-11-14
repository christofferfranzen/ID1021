package Heap;

import java.util.Random;

public class Bench {

    public static Random rnd = new Random();

    public static void main(String[] args) {


        LinkedHeap heap = new LinkedHeap();

        long t0;
        long t1;

        // Warmup
        for (int i = 0; i < 1000000; i++){
            t0 = System.nanoTime();
            heap.enqueue(rnd.nextInt(10000));
            t1 = System.nanoTime();
        }
        for (int i = 0; i < 1000000; i++){
            heap.dequeue();
        }


        for (int i = 0; i < 1023; i++) {
            heap.enqueue(rnd.nextInt(10000));
        }

        long avg1 = 0;

        for (int j = 0; j < 100; j++) {
            int tmp = rnd.nextInt((100 - 10) + 1) + 10;
            t0 = System.nanoTime();
            int tmp2 = heap.push(tmp);
            t1 = System.nanoTime();
            System.out.print(tmp2 + " : ");
            System.out.println(t1 - t0 + " | ");
            avg1 += t1 - t0;
        }

        System.out.println("avg1: " + avg1 / 100);




        long avg2 = 0;

        for (int j = 0; j < 100; j++) {
            int tmp = rnd.nextInt((100 - 10) + 1) + 10;
            t0 = System.nanoTime();
            int prio = heap.dequeue();
            heap.enqueue(tmp + prio);
            t1 = System.nanoTime();
            System.out.println(t1 - t0);
            avg2 += t1 - t0;
        }

        System.out.println("avg2: " + avg2 / 100);

        /*

        int[] list = {1,6,9,2,3,8};

        ArrayHeap heap = new ArrayHeap(10);

        for (int i = 0; i < list.length; i++){
            heap.insert(list[i]);
        }

        for (int i = 0; i < list.length; i++){
            System.out.println(heap.remove());
        }

        heap.print();
         */

    }
}
