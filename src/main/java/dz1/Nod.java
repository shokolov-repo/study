package dz1;

/**
 * Created by dmitriy on 7/27/15.
 *
 * Написать программу, которая находит наибольший
 * общий делитель двух целых положительных чисел.
 */
public class Nod {
    public static void main(String[] args) {
        System.out.println(new NodCalculate().nodCalculate(64, 48));
    }
}

class NodCalculate {

    public NodCalculate() {
    }

    int nodCalculate(int m, int n) {
        int nod = m <= n ? m : n;

        for (; ; nod -= 2) {
            if (n % nod == 0 && m % nod == 0) {
                break;
            }
        }
        return nod;
    }
}


