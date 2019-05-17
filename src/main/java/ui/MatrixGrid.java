package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.logging.Logger;

public class MatrixGrid extends GridPane {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private int size;

    public MatrixGrid(int size) {
        if (size > 15 || size < 2) {
            Main.createAlert(Alert.AlertType.ERROR, "Size must be between 1 and 16!");
            LOGGER.fine("size not valid");
        } else {
            this.size = size;
            init();
        }
    }

    //todo add "header" (maybe dynamic([A,B,C,D,...], [1,2,3,4,...])?
    private void init() {
        LOGGER.fine("initializing...");
        this.setHgap(10);
        this.setVgap(10);
        this.setMaxSize(size * 35, size * 20);
        int row = size;
        int column = size;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                TextField tf = new TextField();
                this.add(tf, i, j);
                System.out.println("i: " + i + "; j: " + j);
            }
        }
        System.out.println("--------------");
    }
}
