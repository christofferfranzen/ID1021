package Heap;

public interface Queue {
    void enqueue(int priority);

    int dequeue();

    boolean isEmpty();
}
