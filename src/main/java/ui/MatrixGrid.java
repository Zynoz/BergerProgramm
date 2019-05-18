package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixGrid extends GridPane {

    private int size;

    private final Logger logger = LogManager.getLogger(MatrixGrid.class);

    public MatrixGrid(int size) {
        if (size > 15 || size < 2) {
            logger.warn("Size must be between 1 and 16!");
            Main.createAlert(Alert.AlertType.ERROR, "Size must be between 1 and 16!");
        } else {
            this.size = size;
            init();
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
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                TextField tf = new TextField();
                this.add(tf, i, j);
            }
        }
    }
}
