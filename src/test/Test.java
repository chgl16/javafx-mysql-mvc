package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/test/test1.fxml"));

        stage.setTitle("chen");

        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
