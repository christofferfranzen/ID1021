package Heap;

public class ArrayHeap implements Queue{

    private int[] heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public ArrayHeap(int maxsize){
        this.maxsize = maxsize;
        size = 0;

        heap = new int[this.maxsize + 1];
    }

    private int parent(int pos){
        return pos/2;
    }

    private int leftChild(int pos){
        return (2 * pos);
    }

    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        if (pos > (size / 2)){
            return true;
        }

        return false;
    }

    private void swap(int fpos, int spos){
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos){
        if (!isLeaf(pos)){
            int swapPos = pos;

            if (rightChild(pos) <= size)
                swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos):rightChild(pos);
            else
                swapPos = leftChild(pos);

            if (heap[pos] > heap[swapPos]){
                swap(pos, swapPos);
                minHeapify(swapPos);
            }
        }
    }

    public void enqueue(int element){
        if (size >= maxsize){
            return;
        }

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    public int dequeue()
    {

        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    @Override
    public boolean isEmpty() {
        return heap.length == 0;
    }
}
