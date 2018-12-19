package com.concurrent;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronoutQueue 必须有生产者消费者同时，不然会一直阻塞。
 * 没有生产者和消费者，队列中不会出现数据。
 */
public class Main {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<Integer>();

        //生产者，不管几个生产者，只会有一个产品进入队列
        Producer producer = new Producer(synchronousQueue);
        producer.start();
        Producer producer1 = new Producer(synchronousQueue);
        producer1.start();
        Producer producer2 = new Producer(synchronousQueue);
        producer2.start();

        //消费者
        Consumer consumer = new Consumer(synchronousQueue);
        consumer.start();
    }
}
