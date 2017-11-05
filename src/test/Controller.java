package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button onload;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    public  void loadIn() {
        System.out.println(userName.getText() + " " + password.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
