package model.utils;

import model.Matrix;
import model.exception.MatrixException;

import java.util.List;

public class MatrixUtils {

    //todo implement
    public static boolean isValidMatrix(List<Integer> matrix) {

        return true;
    }

    public static boolean isValidSize(int size) {
        return size <= 15 && size >= 2;
    }

    //todo implement
    public static Matrix convertToMatrix(List<Integer> matrixList) throws MatrixException {
        int size = (int) Math.sqrt(matrixList.size());
        int[][] matrix = new int[size][size];
        if (!isValidMatrix(matrixList) && !isValidSize(size)) {
            throw new MatrixException("Entered Matrix is not valid!");
        }
        Matrix m = new Matrix(matrix);

        return m;
    }

    public static Matrix multiplyMatrices(Matrix m1, Matrix m2) {
        int m1Size = m1.getSize();
        int m2Size = m2.getSize();
        int[][] product = new int[m1Size][m2Size];

        for (int i = 0; i < m1Size; i++) {
            for (int j = 0; j < m2Size; j++) {

            }

        }

        return new Matrix(product);
    }
}