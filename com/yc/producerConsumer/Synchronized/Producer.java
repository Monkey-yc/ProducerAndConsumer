package com.yc.producerConsumer.Synchronized;

import java.util.concurrent.TimeUnit;
/*
 *@author yc
 * @time 2018/11/16
 */
public class Producer implements Runnable{
    private Resource resouse;

    public Producer(Resource resouse, String ThreadName) {
        this.resouse = resouse;
        new Thread(this, ThreadName).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resouse.produce();
        }
    }
}
