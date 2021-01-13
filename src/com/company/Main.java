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

class standardArrayPrinter extends ArrayPrinter {

    public standardArrayPrinter(ArrayForPrint arrayForPrint) {
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

class prettyArrayPrinter extends ArrayPrinter {


    public prettyArrayPrinter(ArrayForPrint arrayForPrint) {
        super(arrayForPrint);
    }

    @Override
    protected void printElem(int elem) {
        System.out.println("--- " + arrayForPrint.getArrayElement(elem) + " ---");
    }
}


public class Main {


    public static void main(String[] args) {


    }
}