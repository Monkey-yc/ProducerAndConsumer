package com.yc.producerConsumer.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        Resource resouse = new Resource();
        new Producer(resouse, "一号生产者");
        new Producer(resouse, "二号生产者");
        new Producer(resouse, "三号生产者");

        new Consumer(resouse, "一号消费者");
        new Consumer(resouse, "二号消费者");
        new Consumer(resouse, "三号消费者");
    }
}
