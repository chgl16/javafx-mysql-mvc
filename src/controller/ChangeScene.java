package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.Main;

import java.io.IOException;

public class ChangeScene {

    public  ChangeScene(String fxml) throws IOException {
        String src = "/view/" + fxml;
        Parent root = FXMLLoader.load(getClass().getResource(src));

        Main.stage.setTitle("land system");

        Main.stage.setScene(new Scene(root));
        Main.stage.show();
    }
}
