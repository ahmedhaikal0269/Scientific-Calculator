package com.example.scientificcalculator;

public interface queue<T> {
    /** add val to the back of the queue*/
    public void enqueue(T val);

    /** remove and return the first item and throws an IllegalStateException if the queue is Empty*/
    public T dequeue();

    /** return if the queue has 3 or more objects and is ready for a calculation process*/

    public boolean isReady();
}
