package ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.GraphManagment;
import model.Matrix;
import model.utils.MatrixUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class RootBorderPane extends BorderPane {

    private final Logger logger = LogManager.getLogger(RootBorderPane.class);

    private MenuBar menuBar;
    private Menu matrixMenu, file, settings;
    private MenuItem createMatrix, printMatrix, exit;
    private MatrixGrid matrixGrid;
    private Buttons buttons;

    private GraphManagment gm;

    public RootBorderPane() {
        init();
        add();
        listeners();
    }

    private void init() {
        logger.info("initializing RootBorderPane...");

        menuBar = new MenuBar();
        matrixMenu = new Menu("Matrix");
        file = new Menu("File");
        settings = new Menu("Settings");

        createMatrix = new MenuItem("Create new Matrix");
        printMatrix = new MenuItem("printMatrix");
        exit = new MenuItem("Exit");

        matrixGrid = new MatrixGrid(3);
        buttons = new Buttons(this);

        gm = new GraphManagment();
    }

    private void add() {
        logger.info("adding RootBorderPane objects...");

        matrixMenu.getItems().addAll(createMatrix, printMatrix);
        file.getItems().add(exit);

        menuBar.getMenus().addAll(file, matrixMenu, settings);

        this.setTop(menuBar);
        this.setRight(buttons);
        setCenter(matrixGrid);
    }

    private void listeners() {
        logger.info("adding RootBorderPane listeners...");
        createMatrix.setOnAction(event -> newMatrix());
        exit.setOnAction(event -> Platform.exit());
        printMatrix.setOnAction(event -> MatrixUtils.print(matrixGrid.getMatrix()));
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
                size = Integer.parseInt(input.get());
                logger.info("creating new MatrixGrid with size: " + size);

                matrixGrid = new MatrixGrid(size);
                setCenter(matrixGrid);
            } catch (NumberFormatException nfe) {
                logger.error("Not a size: " + input.get());
                Main.createAlert(Alert.AlertType.ERROR, "That ain't a size!");
            }
        } else {
            logger.error("no input");
            Main.createAlert(Alert.AlertType.ERROR, "Enter a size!");
        }
    }

    public GraphManagment getGm() {
        return gm;
    }

    public MatrixGrid getMatrixGrid() {
        return matrixGrid;
    }
}