package LinkedList;

import java.util.Random;

public class Bench {

    public static Random rand = new Random();

    public static void main(String[] args) {

        int[] sizes = {5, 25, 50, 100, 200, 400, 800, 1600, 3200, 6400, 12800};
        //int[] sizes = {100, 1000, 10000, 100000, 1000000, 10000000};

        int k = 1000;
        int loop = 1000;

        /*

        System.out.printf("# Appending a fixed size linkted list to linkte list with length n, time in ns\n");
        System.out.println("n time \tvary the size of the linked\n vary the size of the append list");

        for (int n : sizes) {
            System.out.printf("%8d ", n);

            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                //LinkedList fixed = new LinkedList(100);
                //LinkedList list = new LinkedList(n);
                int[] fixed = new int[100];
                int[] list = new int[n];
                long t0 = System.nanoTime();
                //list.append(fixed);
                int[] tmp = arrayAppend(fixed, list);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.print(min + " : ");


            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                //LinkedList fixed = new LinkedList(100);
                //LinkedList list = new LinkedList(n);
                int[] fixed = new int[100];
                int[] list = new int[n];
                long t0 = System.nanoTime();
                //fixed.append(list);
                int[] tmp = arrayAppend(list, fixed);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.println(min);
        }

         */


        /*

        System.out.printf("# The cost of allocating a linked list of length n, time in ns\n");

        for (int n : sizes) {
            System.out.printf("%8d ", n);

            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                LinkedList tmp = new LinkedList(n);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.println(min);
        }

         */


        /* Test code
        LinkedList list = new LinkedList(0);

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);

        System.out.println(list.length());

        System.out.println(list.find(2));
        System.out.println(list.find(7));
        System.out.println(list.find(4));

        list.remove(2);
        System.out.println(list.find(2));

        LinkedList list2 = new LinkedList(0);

        list2.add(7);
        list2.add(9);

        list.append(list2);

        System.out.println(list.find(7));
        System.out.println(list.find(9));
         */


        /*
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {8,9,10,11};
        int[] c = arrayAppend(a,b);

        for (int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }

         */

        /*

        //DoublyLinkedList list = new DoublyLinkedList(0);
        LinkedList list = new LinkedList(0);

        list.add(10);
        list.add(11);
        list.add(12);
        list.add(99);
        //list.remove(99);

        //DoublyLinkedList.Cell c = new DoublyLinkedList.Cell(99, null, null);
        LinkedList.Cell c = new LinkedList.Cell(99, null);

        list.insert(c);
        list.unlink(c);

        System.out.println(list.find(11));
        System.out.println(list.length());
        System.out.println(list.find(10));
        System.out.println(list.find(99));

         */

        // Senaste

        System.out.printf("# Unlink and insert cell on a linked list of length n, time in ns\n");
        System.out.println("n time \tLinkedList \tDoublyLinkedList");

        for (int n : sizes) {
            System.out.printf("%8d ", n);

            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                LinkedList.Node[] cells = new LinkedList.Node[n];
                int[] indices = generateRandomArray(n, 1000);

                LinkedList list = new LinkedList(0);

                // Add them to the list but also keep a reference to them in
                for (int j = 0; j < n; j++){
                    cells[j] = new LinkedList.Node(0, null);
                    list.insert(cells[j]);
                }

                long t0 = System.nanoTime();
                for (int j = 0; j < indices.length; j++){
                    list.unlink(cells[indices[j]]);
                    list.insert(cells[indices[j]]);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.print(min + " : ");

            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                DoublyLinkedList.Cell[] cells = new DoublyLinkedList.Cell[n];
                int[] indices = generateRandomArray(n, 1000);

                DoublyLinkedList list = new DoublyLinkedList(0);

                // Add them to the list but also keep a reference to them in
                for (int j = 0; j < n; j++){
                    cells[j] = new DoublyLinkedList.Cell(0, null, null);
                    list.insert(cells[j]);
                }

                long t0 = System.nanoTime();
                for (int j = 0; j < indices.length; j++){
                    list.unlink(cells[indices[j]]);
                    list.insert(cells[indices[j]]);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.println(min);
        }
    }

    public static int[] generateRandomArray(int n, int k) {
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = rand.nextInt(n);
        }
        return array;
    }

    public static int[] arrayAppend(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++){
            c[i] = a[i];
        }

        for (int i = 0; i < b.length; i++){
            c[i + a.length] = b[i];
        }

        return c;
    }
}
