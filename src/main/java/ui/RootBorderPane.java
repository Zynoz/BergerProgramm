package ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.GraphManagment;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Optional;
import java.util.logging.Logger;

public class RootBorderPane extends BorderPane {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private MenuBar menuBar;
    private Menu matrixMenu, file, settings;
    private MenuItem createMatrix, exit;
    private MatrixGrid matrixGrid;

    private GraphManagment gm;

    public RootBorderPane() {
        init();
        add();
        listeners();
    }

    private void init() {
        LOGGER.fine("initializing...");

        menuBar = new MenuBar();
        matrixMenu = new Menu("Matrix");
        file = new Menu("File");
        settings = new Menu("Settings");

        createMatrix = new MenuItem("Create new Matrix");
        exit = new MenuItem("Exit");

        matrixGrid = new MatrixGrid(3);
    }

    private void add() {
        LOGGER.info("adding...");

        matrixMenu.getItems().add(createMatrix);
        file.getItems().add(exit);

        menuBar.getMenus().addAll(file, matrixMenu, settings);

        this.setTop(menuBar);
        setCenter(matrixGrid);
    }

    private void listeners() {
        //todo add user input
        LOGGER.fine("listening...");
        createMatrix.setOnAction(event -> newMatrix());
        exit.setOnAction(event -> Platform.exit());
    }

    private void newMatrix() {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("New Matrix");
        textInputDialog.setHeaderText("Enter Matrix Size");
        textInputDialog.setContentText("Size: ");
        int size;
        Optional<String> input = textInputDialog.showAndWait();
        if (input.isPresent()) {
            try {
                size = Integer.parseInt(textInputDialog.showAndWait().get());
            } catch (NumberFormatException nfe) {
                LOGGER.warning("size not valid");
                Main.createAlert(Alert.AlertType.ERROR, "That ain't a size!");
                size = 3;
            }
        } else {
            LOGGER.warning("no input");
            Main.createAlert(Alert.AlertType.ERROR, "Enter a size!");
            size = 3;
        }

        LOGGER.fine("creating new MatrixGrid with size: " + size);

        MatrixGrid mg = new MatrixGrid(size);
        setCenter(mg);
    }
}
