package ru.gb.java_third.first_lesson;

import java.util.ArrayList;

public class FirstLessonApp {

    public static <T> void arrayElementsSwap (T[] arr, int firstElement, int secondElement) {
        T temp = arr[firstElement];
        arr[firstElement] = arr[secondElement];
        arr[secondElement] = temp;
    }

    public static <T> ArrayList<T> arrayToList (T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T i: arr) {
            list.add(i);
        }
        return list;
    }
    
    public static <T> void printArray (T[] arr) {
        System.out.print("[ ");
        for (T i: arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String[] arrString = {"A", "B", "C", "D", "E", "F"};
        Integer[] arrInt = {1, 2, 3, 4, 5};
        Double[] arrDouble = {1.0, 2.0, 3.0, 4.0};

        printArray(arrString);
        arrayElementsSwap(arrString, 0, 5);
        printArray(arrString);

        printArray(arrInt);
        arrayElementsSwap(arrInt, 0, 4);
        printArray(arrInt);

        printArray(arrDouble);
        arrayElementsSwap(arrDouble, 1, 2);
        printArray(arrDouble);

        ArrayList<Integer> arrListInt= new ArrayList<>();
        arrListInt = arrayToList(arrInt);
        System.out.println(arrListInt);


        Apple[] apples = new Apple[12];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }

        Orange[] oranges = new Orange[8];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }

        Box<Orange> orangeBox = new Box<>(oranges);
        Box<Apple> appleBox = new Box<>(apples);
        Box<Apple> anotherAppleBox =new Box<>(new Apple(), new Apple(), new Apple());

        appleBox.add(new Apple());

        System.out.println("Orange Box weight: " + orangeBox.getWeight());
        System.out.println("Apple Box weight: " + appleBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));
        System.out.println("Another Apple Box weight: " + anotherAppleBox.getWeight());

        appleBox.transfer(anotherAppleBox);
        System.out.println("Apple Box weight: " + appleBox.getWeight());
        System.out.println("Another Apple Box weight: " + anotherAppleBox.getWeight());
    }
}
