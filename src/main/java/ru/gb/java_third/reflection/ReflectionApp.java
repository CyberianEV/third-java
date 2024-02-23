package ru.gb.java_third.reflection;

import java.lang.reflect.InvocationTargetException;

public class ReflectionApp {
    public static void main(String[] args) {
        try {
            Tester.start("ru.gb.java_third.reflection.SomeClassWithTests");
            Tester.start(AnotherClassWithTests.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
