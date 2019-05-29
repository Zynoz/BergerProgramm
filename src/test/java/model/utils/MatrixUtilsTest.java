package model.utils;

import model.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixUtilsTest {

    private final Logger logger = LogManager.getLogger(MatrixUtils.class);

    @org.junit.Test
    public void isValidMatrix() {
        logger.info("validating matrix...");
        int[][] m = new int[3][3];
        m[0][0] = 0;
        m[0][1] = 1;
        m[0][2] = 1;
        m[1][0] = 0;
        m[1][1] = 0;
        m[1][2] = 1;
        m[2][0] = 1;
        m[2][1] = 1;
        m[2][2] = 0;
        Matrix matrix = new Matrix(m);
        assert !MatrixUtils.isValidMatrix(matrix);

        int[][] m2 = new int[3][3];
        m[0][0] = 0;
        m[0][1] = 1;
        m[0][2] = 1;
        m[1][0] = 1;
        m[1][1] = 0;
        m[1][2] = 1;
        m[2][0] = 1;
        m[2][1] = 1;
        m[2][2] = 0;
        Matrix matrix2 = new Matrix(m2);
        assert MatrixUtils.isValidMatrix(matrix2);

        int[][] m3 = new int[3][3];
        m[0][0] = 0;
        m[0][1] = -1;
        m[0][2] = 1;
        m[1][0] = 0;
        m[1][1] = 0;
        m[1][2] = 1;
        m[2][0] = 1;
        m[2][1] = 1;
        m[2][2] = 0;
        Matrix matrix3 = new Matrix(m3);
        assert MatrixUtils.isValidMatrix(matrix3);
    }

    @org.junit.Test
    public void isValidSize() {
        logger.info("validating size...");
        assert(MatrixUtils.isValidSize(10));
        assert(!MatrixUtils.isValidSize(20));
    }

    @org.junit.Test
    public void arrayToIndex() {
        logger.info("testing arrayToIndex...");
        int[][] matrix = new int[4][4];

    }
}
