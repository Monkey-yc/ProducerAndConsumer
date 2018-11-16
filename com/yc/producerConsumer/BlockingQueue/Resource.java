package com.yc.producerConsumer.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Resource {
    private static BlockingQueue blockingQueue = new LinkedBlockingDeque(10);

    public void produce() {
        try {
            blockingQueue.put(1);
            System.out.println("【" + Thread.currentThread().getName()
                    + "】生产了一个资源，当前拥有" + blockingQueue.size() + "个资源！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        try {
            blockingQueue.take();
            System.out.println("【" + Thread.currentThread().getName() +
                    "】消费了一个资源， 当前拥有" + blockingQueue.size() + "个资源！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
