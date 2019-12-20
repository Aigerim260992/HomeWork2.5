package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class PassengerThread extends Thread {
    Semaphore sem;
    int id;

    CountDownLatch cdl;
    PassengerThread (Semaphore sem, int id, CountDownLatch cdl){
        this.sem=sem;
        this.id=id;
        this.cdl=cdl;
    }
    public void run (){
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " приобрел билет!");
            sem.release();
            System.out.println("Пассажир " + id + " садится в автобус!");
            cdl.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
