package com.teamfam.ds;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    /**
     * Enqueue onto a queue.
     */
    @Test
    public void enqueueTest(){
        //ARRANGE
        Queue queue = new Queue(10);
        //ACT
        queue.enqueue(5);
        //ASSERT - validate system out is invoked.
    }

    /**
     * Dequeue from a queue.
     */
    @Test
    public void dequeueTest(){
        //ARRANGE
        Queue queue = new Queue(10);
        queue.enqueue(5);
        queue.enqueue(10);
        //ACT
        int item = queue.dequeue();
        //ASSERT
        Assert.assertEquals(5,item);
    }
}