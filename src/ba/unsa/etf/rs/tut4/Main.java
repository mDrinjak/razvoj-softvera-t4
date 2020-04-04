package ba.unsa.etf.rs.tut4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    //--module-path "\Program Files\JavaFX\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 522, 474));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
