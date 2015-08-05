package dz2.matrix;

/**
 * Created by dmitriy on 8/4/15.
 */
public class TestMatrix {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(3);
        System.out.println(matrix.getMatrixSize());
        matrix.fill();
        System.out.println(matrix.toString());
        matrix.print();
        System.out.println();

        Matrix testMatrix = matrix.sum(matrix);
        testMatrix.print();
        System.out.println();
        testMatrix = matrix.multiply(3);
        testMatrix.print();
        System.out.println();
        testMatrix = matrix.multiply(testMatrix);
        testMatrix.print();
        System.out.println();
        testMatrix = matrix.transponse();
        testMatrix.print();
        System.out.println();
        matrix.print();
    }
}
