package dz2.vector;

/**
 * Created by dmitriy on 8/3/15.
 */
public class TestVector {
    public static void main(String[] args) {

        Vector vector = new Vector();

        System.out.println(vector.getNumberLinks());

        vector.add("   1");
        vector.add("   2");
        vector.add("   3");
        vector.add("   4");
        vector.add("   5");
        vector.add("   6");
        vector.add("   7");
        vector.add("   8");
        vector.add("   9");
        vector.add("  10");
        vector.add("  11");


        System.out.println(vector.getNumberLinks());

//        System.out.println(vector.arr.length);

        System.out.println("link" + vector.get(3));

        vector.print();

        vector.remove(10);

        vector.print();

        vector.removeAll();

        vector.print();
    }
}
