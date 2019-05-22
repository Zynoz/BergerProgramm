package ui;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import model.exception.MatrixException;

public class Buttons extends HBox {
    private Button apply;
    //todo add other labels
    private Label distanceLabel, distance, radiusLabel, radius;
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
        distance = new Label("");
        radiusLabel = new Label("radius: ");
        radius = new Label("");
    }

    private void add() {
        getChildren().addAll(apply, distanceLabel, distance, radiusLabel, radius);
    }

    private void listeners() {
        apply.setOnAction(event -> apply());
    }

    private void apply() {
        try {
        rootBorderPane.getGm().createGraph(rootBorderPane.getMatrixGrid().getMatrix());

        } catch (MatrixException me) {
            Main.createAlert(Alert.AlertType.ERROR, me.getMessage());
        }
    }

}
