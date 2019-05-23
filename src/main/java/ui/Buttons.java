package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.exception.MatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buttons extends VBox {

    private final Logger logger = LogManager.getLogger(Buttons.class);

    private Button apply, invert;
    //todo add other labels
    private Label distanceLabel, distance, radiusLabel, radius, nameLabel;
    private TextField name;
    private RootBorderPane rootBorderPane;

    public Buttons(final RootBorderPane rootBorderPane) {
        this.rootBorderPane = rootBorderPane;
        init();
        add();
        listeners();
    }

    private void init() {
        apply = new Button("apply");
        distanceLabel = new Label("distance: ");
        distance = new Label("0");
        radiusLabel = new Label("radius: ");
        radius = new Label("0");
        nameLabel = new Label("name:");
        name = new TextField("Graph");
        invert = new Button("invert");

        setPadding(new Insets(20, 10, 10, 20));
        this.setSpacing(10);
    }

    private void add() {
        getChildren().addAll(nameLabel, name, apply, distanceLabel, distance, radiusLabel, radius, invert);
    }

    private void listeners() {
        apply.setOnAction(event -> apply());
        invert.setOnAction(event -> invert());
    }

    private void apply() {
        try {
            rootBorderPane.getGraphManagment().createGraph(name.getText(), rootBorderPane.getMatrixGrid().getMatrix());
            logger.info(rootBorderPane.getGraphManagment().toString());
            logger.info("matrix is valid");
        } catch (MatrixException me) {
            Main.createAlert(Alert.AlertType.ERROR, me.getMessage());
        }
    }

    private void invert() {
        rootBorderPane.getMatrixGrid().invert();
    }
}
