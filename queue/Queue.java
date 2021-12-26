package queue;

import linkedlist.LinkedList;

public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<T>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public void remove() {
        this.list.remove(this.peek());
    }

    public T peek() {
        return this.list.getFirst().getValue();
    }
}