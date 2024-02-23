package ru.gb.java_third.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tester {
    public static <T> void start (Class<T> c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T object = c.newInstance();
        Method[] methods = object.getClass().getDeclaredMethods();
        SortedMap<Integer, ArrayList<Method>> testMethods = getMethods(methods);
        for (Map.Entry<Integer, ArrayList<Method>> entry : testMethods.entrySet()) {
            for (Method method : entry.getValue()) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static void start (String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName(className);
        start(c);
    }

    private static SortedMap<Integer, ArrayList<Method>> getMethods(Method[] methods) {
        boolean beforeSuite = false;
        boolean afterSuite = false;
        SortedMap<Integer, ArrayList<Method>> testMethods = new TreeMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                priorityCheck(priority);
                if (testMethods.containsKey(priority)) {
                    testMethods.get(priority).add(m);
                } else {
                    addMethodToMap(testMethods, m, priority);
                }
            } else if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite = hasDuplicatesInClass(beforeSuite);
                addMethodToMap(testMethods, m, 0);
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                afterSuite = hasDuplicatesInClass(afterSuite);
                addMethodToMap(testMethods, m, 11);
            }
        }
        return testMethods;
    }

    private static void priorityCheck(int priority) {
        if (priority < 1 || priority > 10) {
            throw new RuntimeException("priority must be inside 1 to 10 range");
        }
    }

    private static boolean hasDuplicatesInClass(boolean methodFlag) {
        if (methodFlag) {
            throw new RuntimeException("It is not allowed to duplicate BeforeSuite and " +
                    "AfterSuite annotations in a class");
        }
        return true;
    }

    private static void addMethodToMap(SortedMap<Integer, ArrayList<Method>> testMethods, Method m, int key) {
        ArrayList<Method> list = new ArrayList<>();
        list.add(m);
        testMethods.put(key, list);
    }
}
