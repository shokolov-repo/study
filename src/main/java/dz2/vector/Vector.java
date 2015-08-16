package dz2.vector;

import java.util.Arrays;

/**
 * Created by dmitriy on 8/2/15.
 */
public class Vector {

    private static final int STARTLENGTH = 10;
    private Object[] arr = new Object[STARTLENGTH];
    private int numberLinks = 0;

    public void removeAll() {
        arr = new Object[STARTLENGTH];
    }

    public void add(Object obj) {

        if (arr.length == numberLinks) {
            doubleLengthArr();
        }
        arr[numberLinks++] = obj;
    }

    public Object get(int index) {
        return arr[index];
    }

    public void remove(int index) {

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[numberLinks--] = null;
    }

    public void print() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Vector{" + "arr=" + Arrays.toString(arr) + '}';
    }

    public int getNumberLinks() {
        return numberLinks;
    }

    private void doubleLengthArr() {

        Object[] doubleArr = new Object[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            doubleArr[i] = arr[i];
        }

        arr = doubleArr;
    }
}
