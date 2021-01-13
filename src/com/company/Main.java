package com.company;


import java.util.Arrays;
import java.util.Objects;


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



}


public class Main {


    public static void main(String[] args) {


    }
}