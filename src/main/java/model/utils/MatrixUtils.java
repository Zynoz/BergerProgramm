package model.utils;

import javafx.scene.control.Alert;
import model.Matrix;
import model.exception.MatrixException;
import ui.Main;

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
        if (!isValidMatrix(matrixList)) {
            throw new MatrixException("Entered Matrix is not valid!");
        } else if (!isValidSize(size)) {
            throw new MatrixException("Entered Matrix is not valid!");
        }
        Matrix matrix = new Matrix();

        return new Matrix();
    }
}
