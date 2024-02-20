package ru.gb.java_third.multithreadng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch startLine = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch finishLine = new CountDownLatch(CARS_COUNT);
    public static final CyclicBarrier anotherStartLine = new CyclicBarrier(CARS_COUNT);
    public static final Lock finishFlag = new ReentrantLock();
    public static void main(String[] args) {
        System.out.println("IMPORTANT ANNOUNCEMENT >>> Preparation!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), startLine, anotherStartLine, finishLine, finishFlag);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            startLine.await();
            System.out.println("IMPORTANT ANNOUNCEMENT >>> The race has started!!!");
            finishLine.await();
            System.out.println("IMPORTANT ANNOUNCEMENT >>> The race is over!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
