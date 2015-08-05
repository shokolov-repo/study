package dz1;

/**
 * Created by dmitriy on 7/31/15.
 * Написать программу проверки того, что заданное
 * число Х – простое (т.е. не делится без остатка ни на какие
 * числа, кроме себя и 1). Число X задавать в коде
 * программы.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(new PrimeNumberCalculate().primeNumberCalculate(11));
    }
}

class PrimeNumberCalculate {

    PrimeNumberCalculate() {
    }

    boolean primeNumberCalculate(int n) {


        for (int i = 2; i == n / 2; i++) {

            if (n % i == 0) {
                return false;
            } else {
                return true;
            }
        }


        return false;
    }
}



