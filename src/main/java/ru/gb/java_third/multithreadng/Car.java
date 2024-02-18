package ru.gb.java_third.multithreadng;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private final CountDownLatch startLine;
    private final CyclicBarrier anotherStartLine;
    private final CountDownLatch finishLine;
    private final Lock finishFlag;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch startLine, CyclicBarrier anotherStartLine, CountDownLatch finishLine, Lock finishFlag) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant #" + CARS_COUNT;
        this.startLine = startLine;
        this.anotherStartLine = anotherStartLine;
        this.finishLine = finishLine;
        this.finishFlag = finishFlag;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " is getting ready");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " is ready");
            startLine.countDown();
            anotherStartLine.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (finishFlag.tryLock()) {
            System.out.println(this.name + " - WIN");
        }
        finishLine.countDown();
    }
}
