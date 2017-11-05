package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import controller.ChangeScene;

public class RootSceneController {

    @FXML
    private Label returnLand;
    @FXML
    private Label label1;
    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    public void ReturnLand() throws Exception {
        new ChangeScene("land.fxml");
    }


}
