package com.example.scientificcalculator;

public class dataQueue<T> implements queue<T> {

    private Node head;
    private Node tail;

    private static class Node<T>{
        T item;
        Node next;
    }

    public dataQueue(){
        head = null;
        tail = null;
    }
    @Override
    public void enqueue(T val) {

        Node<T> newTail = new Node<T>();
        newTail.item = val;

        if(null == head){
            head = newTail;
            tail = newTail;
        }
        else{
            tail.next = newTail;
            tail = newTail;
        }
    }

    @Override
    public T dequeue() {
        if(null != head) {
            T firstTerm = (T) head.item;
            head = head.next;
            return firstTerm;
        }
        return null;
    }

    @Override
    public boolean isReady() {
        if(null != head){
            if(null != head.next){
                if(null != head.next.next)
                    return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return (null == head);
    }

    public void makeEmpty() {
        if (null != head) {
            while (head != tail) {
                head.item = null;
                head = head.next;
            }
            if (head == tail) {
                head = null;
                tail = null;
            }
        }
    }
}
