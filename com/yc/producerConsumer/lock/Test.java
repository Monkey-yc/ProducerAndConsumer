package com.yc.producerConsumer.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition produceCondition = lock.newCondition();
        Condition consumeCondition = lock.newCondition();
        Resource resouse = new Resource(lock, produceCondition, consumeCondition);

        new Producer(resouse, "一号生产者");
        new Producer(resouse, "二号生产者");
        new Producer(resouse, "三号生产者");

        new Consumer(resouse, "一号消费者");
        new Consumer(resouse, "二号消费者");
        new Consumer(resouse, "三号消费者");
    }
}
