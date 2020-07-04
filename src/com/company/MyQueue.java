package com.company;

public class MyQueue<T>  {

    private class Node {
        private Node next;
        private T queue;

        public Node(T queue) {
            this.queue = queue;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T number) {
        Node n = new Node(number);
        if (size == 0) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    private void removeFirst(){
        head = head.next;
        if (size == 1){
            tail = null;
        }
        size--;
    }

    public T poll() throws MyQueueEmptyException{
        if (head == null)
            throw new MyQueueEmptyException();
        T queue = head.queue;
        removeFirst();
        return queue;
    }

    public T peek() throws MyQueueEmptyException {
        if (head == null)
            throw new MyQueueEmptyException();
        return head.queue;
    }
    boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return size;
    }

    public static class MyQueueEmptyException extends Exception {
        public MyQueueEmptyException() {
            super("Очередь пуста!!!");
        }

        public MyQueueEmptyException(String message) {
            super(message);
        }
    }
}
