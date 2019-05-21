package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.GraphManagment;
import model.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MatrixGrid extends GridPane {

    private final Logger logger = LogManager.getLogger(MatrixGrid.class);

    private int size;
    private List<TextField> textFields = new ArrayList<>();
    private static final List<Label> headersX = new ArrayList<>();
    private static final List<Label> headersY = new ArrayList<>();

    static  {
        headersX.add(new Label(""));
        headersX.add(new Label("A"));
        headersX.add(new Label("B"));
        headersX.add(new Label("C"));
        headersX.add(new Label("D"));
        headersX.add(new Label("E"));
        headersX.add(new Label("F"));
        headersX.add(new Label("G"));
        headersX.add(new Label("H"));
        headersX.add(new Label("I"));
        headersX.add(new Label("J"));
        headersX.add(new Label("K"));
        headersX.add(new Label("L"));
        headersX.add(new Label("M"));
        headersX.add(new Label("N"));
        headersX.add(new Label("O"));

        headersY.add(new Label(""));
        headersY.add(new Label("A"));
        headersY.add(new Label("B"));
        headersY.add(new Label("C"));
        headersY.add(new Label("D"));
        headersY.add(new Label("E"));
        headersY.add(new Label("F"));
        headersY.add(new Label("G"));
        headersY.add(new Label("H"));
        headersY.add(new Label("I"));
        headersY.add(new Label("J"));
        headersY.add(new Label("K"));
        headersY.add(new Label("L"));
        headersY.add(new Label("M"));
        headersY.add(new Label("N"));
        headersY.add(new Label("O"));
    }

    public MatrixGrid(int size) {
        if (size > 15 || size < 2) {
            logger.warn("Size must be between 1 and 16!");
            Main.createAlert(Alert.AlertType.ERROR, "Size must be between 1 and 16!");
        } else {
            this.size = ++size;
            init();
            addHeader();
        }
    }

    //todo add "header" (maybe dynamic([A,B,C,D,...], [1,2,3,4,...])?
    private void init() {
        logger.info("initializing...");
        this.setHgap(10);
        this.setVgap(10);
        this.setMaxSize(size * 35, size * 20);
        int row = size;
        int column = size;
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                TextField tf = new TextField();
                textFields.add(tf);
                this.add(tf, i, j);
            }
        }
    }

    private void addHeader() {
        logger.info("adding headers...");
        for (int i = 0; i < size; i++) {
            this.add(headersX.get(i), i, 0);
            this.add(headersY.get(i), 0, i);
            logger.info("adding x: " + headersX.get(i).getText());
            logger.info("adding y: " + headersY.get(i).getText());
        }
    }

    public Matrix getMatrix() {
        int[][] matrix = new int[size][size];
        int row = size;
        int column = size;
        int cursor = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(textFields.get(cursor).getText());
                } catch (NumberFormatException nfe) {
                    matrix[i][j] = -1;
                }
                cursor++;
            }
        }
        return new Matrix(matrix);
    }
}