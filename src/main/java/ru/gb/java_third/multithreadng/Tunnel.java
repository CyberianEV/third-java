package ru.gb.java_third.multithreadng;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore tunnelBottleNeck;
    public Tunnel(int width) {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
        tunnelBottleNeck = new Semaphore(width);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " is preparing for the stage(waiting): " + description);
                tunnelBottleNeck.acquire();
                System.out.println(c.getName() + " has started the stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " has finished the stage: " + description);
                tunnelBottleNeck.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
