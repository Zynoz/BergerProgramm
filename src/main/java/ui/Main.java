package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {

    private static final Logger LOGGER = Logger.getLogger("");

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        RootBorderPane root = new RootBorderPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        LOGGER.fine("");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void createAlert(Alert.AlertType alertType, String message) {

        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
