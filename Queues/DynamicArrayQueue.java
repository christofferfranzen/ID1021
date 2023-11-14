package Queues;

public class DynamicArrayQueue {
    private Integer[] list;
    private int capacity;
    private int count;
    private int i;
    private int k;

    public DynamicArrayQueue(int capacity) {
        list = new Integer[capacity];
        this.capacity = capacity;
        this.count = 0;
        this.i = 0;
        this.k = 0;
    }

    public void add(Integer item) {
        if (count == capacity) {
            resize(capacity * 2);
        }
        list[k] = item;
        count++;
        k = (k + 1) % capacity;
    }

    public Integer remove() {
        if (count == 0) {
            return null;
        } else {
            Integer tmp = list[i];
            count--;
            i = (i + 1) % capacity;

            if (count < capacity / 4) {
                resize(capacity / 2);
            }
            return tmp;
        }
    }

    private void resize(int newSize) {
        Integer[] newList = new Integer[newSize];

        for (int i = 0; i < count; i++){
            newList[i] = list[(this.i +i) % capacity];
        }

        list = newList;
        capacity = newSize;
        i = 0;
        k = count;
    }
}
