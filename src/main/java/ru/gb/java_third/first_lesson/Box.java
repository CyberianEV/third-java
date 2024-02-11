package ru.gb.java_third.first_lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Box <T extends Fruit> {
    ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = arrayToList(fruits);
    }

    public float getWeight() {
        float sum = 0;
        for (T i: fruits) {
            sum += i.getWeight();
        }
        return sum;
    }

    public boolean compare (Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void add (T fruit) {
        fruits.add(fruit);
    }

    public void transfer (Box<T> another) {
        Iterator<T> iter = fruits.iterator();
        while (iter.hasNext()) {
            another.add(iter.next());
            iter.remove();
        }
    }

    private ArrayList<T> arrayToList (T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }
}
