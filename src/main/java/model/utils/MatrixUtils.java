package model.utils;

import model.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixUtils {

    private MatrixUtils() {

    }

    private static final Logger logger = LogManager.getLogger(MatrixUtils.class);

    //todo implement
    public static boolean isValidMatrix(final Matrix matrix) {
        int[][] m = matrix.getGrid();
        for (int dia = 0; dia < m.length; dia++) {
            if (m[dia][dia] != 0) {
                return false;
            }
            for (int j = 0; j < m[dia].length; j++) {
                if (m[dia][j] != m[j][dia]) {
                    return false;
                }
                if (m[dia][j] == -1 || m[j][dia] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSize(int size) {
        return size <= 15 && size >= 2;
    }

    public static void print(Matrix m) {
        for (int i = 1; i < m.getGrid().length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < m.getGrid()[i].length; j++) {
                sb.append(m.getGrid()[j][i]).append(" ");
            }
            logger.info(sb.toString());
        }
    }

    public static int arrayToIndex(final int[][] matrix, final int x, final int y) {
        int index = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                index++;
                if (i == x && j == y) {
                    return index;
                }
            }
        }
        return -1;
    }
}
