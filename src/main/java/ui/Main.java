package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main extends Application {

    private final Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        logger.info("starting application...");
        RootBorderPane root = new RootBorderPane();
        primaryStage.setTitle("Hello Graphs");
        primaryStage.setScene(new Scene(root, 750, 600));
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