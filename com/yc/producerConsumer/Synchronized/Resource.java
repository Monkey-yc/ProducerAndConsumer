package com.yc.producerConsumer.Synchronized;
/*
 *@author yc
 * @time 2018/11/16
 */
public class Resource {
    private static int count = 0;
    private static int size = 10;

    public synchronized void produce() {
        if (count < size) {
            count++;
            System.out.println("【" + Thread.currentThread().getName()
                   + "】生产了一个资源，当前拥有" + count + "个资源！");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (count > 0) {
            count--;
            System.out.println("【" + Thread.currentThread().getName() +
                    "】消费了一个资源， 当前拥有" + count + "个资源！");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
