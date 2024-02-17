package ru.gb.java_third.multithreadng;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " is preparing for the stage(waiting): " + description);
                System.out.println(c.getName() + " has started the stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " has finished the stage: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
