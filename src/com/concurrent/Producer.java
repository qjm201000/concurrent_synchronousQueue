package com.concurrent;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * 生产者
 */
public class Producer extends Thread{
    private SynchronousQueue<Integer> sychronousQueue;
    public Producer(SynchronousQueue<Integer> sychronousQueue){
        this.sychronousQueue = sychronousQueue;
    }

    @Override
    public void run() {
        while(true){
            int random = new Random().nextInt(1000);
            System.out.println(Thread.currentThread().getName()+",生产一个产品："+random);
            System.out.println(Thread.currentThread().getName()+",等待三秒后运输出去");
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+",产品加入队列");
                sychronousQueue.put(random);
                System.out.println(Thread.currentThread().getName()+",加入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
