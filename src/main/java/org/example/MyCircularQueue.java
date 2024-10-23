package org.example;

public class MyCircularQueue {

    // Class variable initialization
    private int[] queue; // our queue constructed of array
    private int index; // index of the head element
    private int size; // size of queue
    private int num; // number of elements in queue
    // Didnt use this, seems to be easier to just calculate it everytime
    //private int tail;


    public MyCircularQueue(int k) {
        this.size = k;
        this.index = 0;
        this.queue = new int[k];
        this.num = 0;
    }

    public boolean enQueue(int value) {
//        throw new UnsupportedOperationException("Not implemented yet");
        if (this.isFull()) {
            return false;
        }
        // Circular so need to mod to actually find tail
        int tail = (this.index + this.num) % this.size;
        this.queue[tail] = value;
        this.num++;
        return true;

    }

    public boolean deQueue() {
//        throw new UnsupportedOperationException("Not implemented yet");
        if (this.isEmpty()) {
            return false;
        }
        this.queue[this.index] = 0;
        this.index = (this.index + 1) % this.size;
        this.num--;
        return true;
    }

    public int Front() {
//        throw new UnsupportedOperationException("Not implemented yet");
        if (this.isEmpty()) {
            return -1;
        }
        return this.queue[this.index];
    }

    public int Rear() {
//        throw new UnsupportedOperationException("Not implemented yet");
        if (this.isEmpty()) {
            return -1;
        }
        int tail = (this.index + this.num - 1) % this.size;
        return this.queue[tail];
    }

    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not implemented yet");
        return this.num == 0;
    }

    public boolean isFull() {
//        throw new UnsupportedOperationException("Not implemented yet");
        return this.num == this.size;
    }
}
