package Queues;

public class ArrayQueue {
    private int i;  // front
    private int k;  // rear
    private int capacity;
    private Integer[] list;

    public ArrayQueue(int capacity) {
        i = 0;
        k = 0;
        this.capacity = capacity;
        list = new Integer[capacity];
    }

    public void add(Integer item) {
        if (length() == capacity-1) {
            throw new RuntimeException("Queue Overflow");
        } else {
            list[k] = item;
            k = (k + 1) % capacity;  // Wrap around when reaching the end
        }
    }

    public Integer remove() {
        if (i == k){
            return null;
        }
        else {
            Integer tmp = list[i];
            list[i] = null;
            i = (i + 1) % capacity;  // Wrap around when reaching the end
            return tmp;
        }
    }

    public int length() {
        return (capacity - i + k) % capacity;  // Correct length calculation for wrap-around
    }
}