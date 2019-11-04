package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.exception.MatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buttons extends GridPane {

    private final Logger logger = LogManager.getLogger(Buttons.class);

    private Label nameLabel;
    private TextField graphName;
    private Button apply;
    private Button invert;
    private Label distanceLabel;
    private Label distance;
    private Label radiusLabel;
    private Label radius;
    private Label nodeALabel;
    private TextField nodeA;
    private Label nodeBLabel;
    private TextField nodeB;
    private Label diameterLabel;
    private Label diameter;

    private RootBorderPane rootBorderPane;

    public Buttons(final RootBorderPane rootBorderPane) {
        this.rootBorderPane = rootBorderPane;
        init();
        add();
        listeners();
    }

    private void init() {
        nameLabel = new Label("Name:");
        graphName = new TextField();
        graphName.setPromptText("name");
        nodeALabel = new Label("Node A:");
        nodeA = new TextField();
        nodeA.setPromptText("A");
        nodeBLabel = new Label("Node B:");
        nodeB = new TextField();
        nodeB.setPromptText("B");
        distanceLabel = new Label("Distance:");
        distance = new Label("0");
        diameterLabel = new Label("Diameter:");
        diameter = new Label("0");
        radiusLabel = new Label("Radius:");
        radius = new Label("0");
        apply = new Button("Calculate");
        invert = new Button("Invert matrix");

        setPadding(new Insets(20, 10, 10, 20));
    }

    private void add() {
        this.add(nameLabel, 0, 0);
        this.add(graphName, 1, 0);
        this.add(nodeALabel, 0, 1);
        this.add(nodeA, 1, 1);
        this.add(nodeBLabel, 0, 2);
        this.add(nodeB, 1, 2);
        this.add(distanceLabel, 0, 3);
        this.add(distance, 1, 3);
        this.add(diameterLabel, 0, 4);
        this.add(diameter, 1, 4);
        this.add(radiusLabel, 0, 5);
        this.add(radius, 1, 5);
        this.add(apply, 0, 6);
        this.add(invert, 1, 6);
    }

    private void listeners() {
        apply.setOnAction(event -> apply());
        invert.setOnAction(event -> invert());
    }

    private void apply() {
        try {
            rootBorderPane.getGraphManagment().createGraph(graphName.getText(), rootBorderPane.getMatrixGrid().getMatrix());
            logger.info(rootBorderPane.getGraphManagment().toString());
            logger.info("matrix is valid");
            System.out.println(rootBorderPane.getMatrixGrid().toString());
        } catch (MatrixException me) {
            Main.createAlert(Alert.AlertType.ERROR, me.getMessage());
        }
    }

    private void invert() {
        rootBorderPane.getMatrixGrid().invert();
    }
}
