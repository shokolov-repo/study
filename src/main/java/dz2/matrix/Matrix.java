package dz2.matrix;

import java.util.Arrays;

/**
 * Created by dmitriy on 8/4/15.
 */
public class Matrix {
    private int matrixSize;
    private int[][] matrix;

    public Matrix(int matrixSize) {
        this.matrixSize = matrixSize;
        this.matrix = new int[matrixSize][matrixSize];
    }

    public Matrix fill() {

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                set(i, j, (int) (Math.random() * 10));
            }
        }
        return this;
    }

    public Matrix sum(Matrix m) {
        Matrix tmp = new Matrix(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                tmp.set(i, j, (get(i, j) + m.get(i, j)));
            }
        }
        return tmp;
    }

    public Matrix multiply(int num) {
        Matrix tmp = new Matrix(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                tmp.set(i, j, get(i, j) * num);
            }
        }
        return tmp;
    }

    public Matrix multiply(Matrix m) {
        Matrix tmp = new Matrix(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                tmp.set(i, j, calculateValue(m, i, j));
            }
        }
        return tmp;
    }

    public Matrix transponse() {
        Matrix tmp = new Matrix(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                tmp.set(j, i, get(i, j));
            }
        }
        return tmp;
    }

    public void print() {
        for (int i = 0; i < matrixSize; i++) {
            System.out.println();
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(get(i, j) + " ");
            }
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrixSize=" + matrixSize +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }


    public int[][] getMatrix() {
        return matrix;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    private int get(int i, int j) {
        return getMatrix()[i][j];
    }

    private void set(int i, int j, int val) {
        getMatrix()[i][j] = val;

    }

    private int calculateValue(Matrix m, int i, int j) {
        int result = 0;

        for (int r = 0; r < matrixSize; r++) {
            result += get(i, r) * m.get(r, j);
        }
        return result;
    }

}
