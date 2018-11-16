package com.yc.producerConsumer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Resource {
    private static int count = 0;
    private static int size = 10;

    private Lock lock;
    private Condition produceCondition;
    private Condition consumeCondition;

    public Resource(Lock lock, Condition produceCondition, Condition consumeCondition) {
        this.lock = lock;
        this.produceCondition = produceCondition;
        this.consumeCondition = consumeCondition;
    }

    public void produce() {
        lock.lock();
        try {
            if (count < size) {
                count++;
                System.out.println("【" + Thread.currentThread().getName()
                        + "】生产了一个资源，当前拥有" + count + "个资源！");
                consumeCondition.signalAll();
            } else {
                try {
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            if (count > 0) {
                count--;
                System.out.println("【" + Thread.currentThread().getName()
                        + "】消费了一个资源，当前拥有" + count + "个资源！");
                produceCondition.signalAll();
            } else {
                try {
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
