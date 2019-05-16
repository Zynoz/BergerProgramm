import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.RootBorderPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        RootBorderPane root = new RootBorderPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
