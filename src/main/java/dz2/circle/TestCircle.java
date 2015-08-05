package dz2.circle;

/**
 * Created by dmitriy on 8/2/15.
 */
public class TestCircle {
    public static void main(String[] args) {

        Circle circle = new Circle(5, 10, 20);
        circle.print();

        circle.move(2, 3);

        circle.print();

        System.out.println();

        System.out.println(circle.containsPoint(10, 15));
        System.out.println(circle.containsPoint(20, 30));

        System.out.println();

        System.out.println(circle.containsCircle(7, 13, 19));
        System.out.println(circle.containsCircle(7, 13, 21));

        System.out.println();

        circle.print();

    }
}
