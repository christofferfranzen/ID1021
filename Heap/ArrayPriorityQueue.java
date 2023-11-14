package Heap;

/*
Implement a priority queue that holds integers, smaller numbers have
higher priority. Your first implementation should have an add method with
a time complexity of O(1) and a remove time complexity of O(n) where n
is the number of elements in the queue.
 */

public class ArrayPriorityQueue {

    private int[] list;
    private int size;

    private boolean reversed;

    public ArrayPriorityQueue(int maxSize, boolean reversed){
        list = new int[maxSize];
        size = 0;
        this.reversed = reversed;
    }

    public void add(int item){
        if (size == list.length){
            throw new RuntimeException("\nQueue is full");
        }

        if (reversed){
            int i = size - 1;
            while (i >= 0 && list[i] > item){
                list[i+1] = list[i];
                i--;
            }
            list[i+1] = item;
            size++;
        }else {
            list[size++] = item;
        }
    }

    public int remove(){
        if (size == 0) {
            throw new RuntimeException("\nQueue is empty");
        }

        if (reversed){
            return list[--size];
        }
        else {

        }

        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] < list[minIndex]) {
                minIndex = i;
            }
        }

        int min = list[minIndex];
        list[minIndex] = list[size - 1]; // Replacing the element at the minIndex position in the list with the last element in the list.
        size--;
        return min;
    }
}
