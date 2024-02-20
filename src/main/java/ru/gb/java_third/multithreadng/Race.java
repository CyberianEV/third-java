package ru.gb.java_third.multithreadng;

import java.util.Arrays;
import java.util.Vector;

public class Race {
    private Vector<Stage> stages;
    public Vector<Stage> getStages() {
        return stages;
    }
    public Race(Stage... stages) {
        this.stages = new Vector<>(Arrays.asList(stages));
    }
}
