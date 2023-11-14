package Heap;

import java.util.Random;

public class Bench2 {

    public static Random rnd = new Random();

    public static void main(String[] args) {
        int[] sizes = {100};

        for (int n : sizes) {

            LinkedHeap heap = new LinkedHeap();

            for (int i = 0; i < 1023; i++){
                heap.enqueue(rnd.nextInt(10000));
            }

            System.out.println("Sequence: " + n + " (push)");

            int time = 0;
            double amtDepth = 0;

            for (int i = 0; i < n; i++) {
                int random = rnd.nextInt((100 - 10) + 1) + 10;
                long t0 = System.nanoTime();
                int depth = heap.push(random);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                time += t;
                amtDepth += depth;
                System.out.println("depth: " + depth + ", time: " + t);
            }

            System.out.println("Average time: " + time/n + " Avrage depth: " + amtDepth/n);
        }

        for (int n : sizes) {

            LinkedHeap heap = new LinkedHeap();

            for (int i = 0; i < 1023; i++){
                heap.enqueue(rnd.nextInt(10000));
            }

            System.out.println("Sequence: " + n + " (dequeue and enqueue)");

            int time = 0;

            for (int i = 0; i < n; i++) {
                int random = rnd.nextInt((100 - 10) + 1) + 10;
                long t0 = System.nanoTime();
                int tmp = heap.dequeue();
                heap.enqueue(tmp + random);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                time += t;
                System.out.println("time: " + t);
            }

            System.out.println("Average time: " + time/n);
        }
    }
}
