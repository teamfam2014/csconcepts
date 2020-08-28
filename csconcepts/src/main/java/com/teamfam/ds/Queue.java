package com.teamfam.ds;

public class Queue {
    private int[] list;
    private int curSize;

    public Queue(int capacity){
        if (capacity < 0 ){
            throw new IllegalArgumentException("Invalid Capacity size");
        }
        list = new int[capacity];
    }

    public void enqueue(int item){
        if (curSize >= list.length){
            System.out.println("Queue is at capacity. We cannot add any more. Capacity=" + list.length);
        }else{
            list[curSize++] = item;
            System.out.println("Item " + item + " has been enqueued.");
        }
    }

    public int dequeue(){
        int item = list[0];
        for(int index = 0; index < list.length-1; index++){
            list[index] = list[index+1];
        }
        list[list.length-1] = 0;
        return item;
    }
}