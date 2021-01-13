package com.company;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class ArrayPrinter {
    ArrayForPrint arrayForPrint;

    public ArrayPrinter(ArrayForPrint arrayForPrint) {
        this.arrayForPrint = arrayForPrint;
    }

    public void printArray() {

        for (int i = 0; i < arrayForPrint.size(); i++) {
            printElem(i);
        }
    }

    protected void printElem(int elem) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayPrinter that = (ArrayPrinter) o;
        return arrayForPrint.equals(that.arrayForPrint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayForPrint);
    }

    @Override
    public String toString() {
        return "ArrayPrinter{" +
                "arrayForPrint=" + arrayForPrint +
                '}';
    }
}

class ArrayForPrint {
    int[] array;

    public ArrayForPrint(int[] array) {
        this.array = array;
    }

    public int getArrayElement(int index) {
        int value = array[index];
        return value;
    }

    public int size() {
        return array.length;
    }

    public void setArray(int value, int index) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
    }

    public int[] arrays(int[] arr1, int[] arr2, int[] arr3) {
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            setArray(arr2[i - arr1.length], i);
        }
        for (int i = arr1.length + arr2.length; i < arr1.length + arr2.length + arr3.length; i++) {
            setArray(arr3[i - (arr1.length + arr2.length)], i);
        }
        return array;
    }
}

class StandardArrayPrinter extends ArrayPrinter {

    public StandardArrayPrinter(ArrayForPrint arrayForPrint) {
        super(arrayForPrint);
    }

    @Override
    protected void printElem(int elem) {

        System.out.println("*** " + arrayForPrint.getArrayElement(elem) + " ***");

    }
}

class DefaultArrayPrinter extends ArrayPrinter {

    public DefaultArrayPrinter(ArrayForPrint arrayForPrint) {
        super(arrayForPrint);
    }

    @Override
    protected void printElem(int elem) {
        System.out.println("{ " + arrayForPrint.getArrayElement(elem) + " }");
    }
}

class PrettyArrayPrinter extends ArrayPrinter {


    public PrettyArrayPrinter(ArrayForPrint arrayForPrint) {
        super(arrayForPrint);
    }

    @Override
    protected void printElem(int elem) {
        System.out.println("--- " + arrayForPrint.getArrayElement(elem) + " ---");
    }
}

public class Main {
    public static int[] newArray() {
        int size = (int) (Math.random() * 10 + 1);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 - 1);
        }
        return array;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] array1 = newArray();
        int[] array2 = newArray();
        int[] array3 = newArray();
        ArrayForPrint arrayForPrint = new ArrayForPrint(array1);
        arrayForPrint = new ArrayForPrint(arrayForPrint.arrays(array1, array2, array3));

        ArrayPrinter arrayPrinter;

        while (true) {
            System.out.println("choice you printer");
            System.out.println("pretty printer - 1");
            System.out.println("standard printer - 2");
            System.out.println("default printer - 3");
            System.out.println("exit - 4");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                arrayPrinter = new StandardArrayPrinter(arrayForPrint);
                arrayPrinter.printArray();

            } else if (choice == 2) {
                arrayPrinter = new DefaultArrayPrinter(arrayForPrint);
                arrayPrinter.printArray();

            } else if (choice == 3) {
                arrayPrinter = new PrettyArrayPrinter(arrayForPrint);
                arrayPrinter.printArray();

            } else if (choice == 4) break;
            else {
                System.out.println("your command invalid");
                continue;
            }

        }
    }
}