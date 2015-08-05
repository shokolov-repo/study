package dz1;

/**
 * Created by dmitriy on 7/28/15.
 * Написать программу, которая находит сумму цифр
 * произвольного целого числа.
 */
public class SumNumber {
    public static void main(String[] args) {

        System.out.println(new SumNumberCalculate().sumNumber(12345));
    }
}

class SumNumberCalculate {

    SumNumberCalculate() {
    }

    int sumNumber(int m) {
//    int result = 0;
//        String number = Integer.toString(Math.abs(m));
//        for (int i = 0; i < number.length(); i++) {
//            result += Character.getNumericValue(number.charAt(i));
//        }
        if (m == 0) {
            return 0;
        }
        return m % 10 + sumNumber(m / 10);

    }
}

