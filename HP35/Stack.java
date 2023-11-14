package HP35;

import java.util.EmptyStackException;

public abstract class Stack {
    public abstract void push(int x);
    public abstract int pop();
}

class StaticStack extends Stack {
    private int top = -1;
    int data[];

    public StaticStack(int size){
        data = new int[size];
    }

    public void push(int x) {
        if (isFull()){
            throw new StackOverflowError("Stack Overflow");
        }

        data[++top] = x;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        return data[top--];
    }

    private boolean isFull(){
        return top >= data.length - 1;
    }
    private boolean isEmpty(){
        return top < 0;
    }
}

class DynamicStack extends Stack {
    static final int STACK_SIZE = 8;
    static final int STACK_CHANGE = 8;
    static final int STACK_WAIT = 4;
    private int top = -1;
    private int wait = 0;
    int data[] = new int[STACK_SIZE];

    public void push(int x) {
        if (isFull()){
            //throw new StackOverflowError("Stack Overflow");
            stackIncrease();
        }

        data[++top] = x;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        if (top < data.length - STACK_CHANGE && wait <= 0){
            wait = STACK_WAIT;
            stackDecrease();
        }
        else {
            wait--;
        }

        return data[top--];
    }

    private boolean isFull(){
        return top >= data.length - 1;
    }
    private boolean isEmpty(){
        return top < 0;
    }

    private void stackIncrease(){
        int tmp[] = new int[data.length + STACK_CHANGE];

        for (int i = 0; i < data.length; i++){
            tmp[i] = data[i];
        }

        data = tmp;
    }

    private void stackDecrease(){
        int tmp[] = new int[data.length - STACK_CHANGE];

        for (int i = 0; i < tmp.length; i++){
            tmp[i] = data[i];
        }

        data = tmp;
    }
}