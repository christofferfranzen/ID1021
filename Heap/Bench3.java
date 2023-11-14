package Heap;

import java.util.Random;

public class Bench3 {

    public static Random rand = new Random();

    public static void main(String[] args) {
        int[] sizes = {100, 200, 400, 800, 1600};

        // Warm up
        {
            int n = 100;
            int k = 100;
            ListPriorityQueue lqueue = new ListPriorityQueue();
            ListPriorityQueue2 lqueue2 = new ListPriorityQueue2();

            for (int i = 0; i < 10; i++){
                bench(lqueue, k, n);
                bench(lqueue2, k, n);
            }
        }

        // Bench

        int k = 10;

        for (int n : sizes) {
            ListPriorityQueue lqueue = new ListPriorityQueue();

            double timelqueue = bench(lqueue, k, n);

            ListPriorityQueue2 lqueue2 = new ListPriorityQueue2();

            double timelqueue2 = bench(lqueue2, k, n);

            System.out.println("n: " + n + " ListPriorityQueue: " + timelqueue + ", ListPriorityQueue2: " + timelqueue2);

        }
    }

    public static double bench(Queue queue, int k, int n){
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++){
            queue.enqueue(rand.nextInt(n));
        }

        for (int i = 0; i < k; i++) {
            int random = rand.nextInt(n);
            long t0 = System.nanoTime();
            for (int j = 0; j < 100; j++){
                queue.dequeue();
                queue.enqueue(random);
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        return min;
    }
}
