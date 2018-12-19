package com.concurrent;

import java.util.concurrent.SynchronousQueue;

/**
 * 消费者
 */
public class Consumer extends Thread{
    private SynchronousQueue<Integer> synchronousQueue;
    public Consumer(SynchronousQueue<Integer> synchronousQueue){
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(Thread.currentThread().getName()+",消费者等待");
                int random = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+",消费者消费了产品："+random);
                System.out.println(Thread.currentThread().getName()+",-----------------------------------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
