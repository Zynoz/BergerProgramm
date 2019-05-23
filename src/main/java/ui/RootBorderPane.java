package ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.GraphManagment;
import model.utils.MatrixUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RootBorderPane extends BorderPane {

    private final Logger logger = LogManager.getLogger(RootBorderPane.class);

    private MenuBar menuBar;
    private Menu matrixMenu, file, settings;
    private MenuItem createMatrix, printMatrix, exit;
    private MatrixGrid matrixGrid;
    private Buttons buttons;

    private int size;

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

        matrixGrid = new MatrixGrid(3, true);
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
        Dialog dialog = new Dialog();
        Button ok = new Button("Ok");
        Label sizeLabel = new Label("Size: ");
        Label headerLabel = new Label("Header: ");
        TextField sizeField = new TextField();
        ComboBox<String> header = new ComboBox();

        header.getItems().addAll("ABC", "123");
        header.getSelectionModel().select(0);
        sizeField.setText(String.valueOf(5));
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        ok.setOnAction(event -> {
            try {
                size = Integer.parseInt(sizeField.getText());
                if (header.getSelectionModel().getSelectedItem().equals("ABC")) {
                    matrixGrid = new MatrixGrid(size, false);
                } else {
                    matrixGrid = new MatrixGrid(size, true);
                }
                setCenter(matrixGrid);
                dialog.close();
            } catch (NumberFormatException nfe) {
                logger.error("Not a size: " + sizeField.getText());
                Main.createAlert(Alert.AlertType.ERROR, "That's no valid size!");
            }
        });

        GridPane gridPane = new GridPane();

        dialog.setTitle("New Matrix");

        gridPane.add(sizeLabel, 0, 0);
        gridPane.add(sizeField, 0, 1);
        gridPane.add(headerLabel, 1, 0);
        gridPane.add(header, 1, 1);
        gridPane.add(ok, 2, 0);

        dialog.getDialogPane().setContent(gridPane);
        dialog.showAndWait();
    }

    public GraphManagment getGraphManagment() {
        return gm;
    }

    public MatrixGrid getMatrixGrid() {
        return matrixGrid;
    }
}
