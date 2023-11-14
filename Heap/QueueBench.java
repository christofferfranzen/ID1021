package Heap;

import java.util.Random;

public class QueueBench {
    public static Random rand = new Random();

    public static void main(String[] args) {

        // Warm up
        {
            //ListPriorityQueue queue = new ListPriorityQueue();
            //bench(queue, 10000, 10000);

            LinkedHeap heap1 = new LinkedHeap();
            bench(heap1, 1000000, 1000000);

            //ListPriorityQueue2 queue2 = new ListPriorityQueue2();
            //bench(queue2, 10000, 10000);

            ArrayHeap heap2 = new ArrayHeap(100000);
            bench(heap2, 1000000, 1000000);
        }


        int[] sizes = {100, 200, 400, 800, 1600, 3200};

        System.out.println("#Dequeue and enqueue on a queue with size n, time in ns");

        for (int n : sizes) {

            int k = 10000000;

            System.out.printf("%8d ", n);

            /*

            ListPriorityQueue queue = new ListPriorityQueue();

            System.out.print(" Queue1: " + bench(queue, k, n));

            ListPriorityQueue2 queue2 = new ListPriorityQueue2();

            System.out.println(" Queue2: " + bench(queue2, k, n));

            //System.out.printf("%8.0f\n", (min));
            //System.out.println(min);

             */

            LinkedHeap heap1 = new LinkedHeap();

            System.out.print(" Heap1: " + bench(heap1, k, n));

            ArrayHeap heap2 = new ArrayHeap(n);

            System.out.println(" Heap2: " + bench(heap2, k, n));
        }
    }

    public static double bench(Queue queue, int k, int n){
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++){
            queue.enqueue(rand.nextInt(n));
        }

        double time = 0;

        for (int i = 0; i < k; i++) {
            int tmp = rand.nextInt(n);
            long t0 = System.nanoTime();
            queue.dequeue();
            queue.enqueue(tmp);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            time += t;
            //if (t < min)
            //    min = t;
        }

        // System.out.println(" Queue2: " + time/k);

        //return min;
        return time/k;
    }
}
