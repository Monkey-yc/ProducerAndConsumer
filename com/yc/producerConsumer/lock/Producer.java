package com.yc.producerConsumer.lock;

import java.util.concurrent.TimeUnit;

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
