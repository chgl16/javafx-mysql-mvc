package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import controller.sql.GetDBConnection;

public class LandController implements Initializable {

    @FXML
    private Button onload;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Label prompt;

    @FXML
    public void loadIn() throws Exception {
        System.out.println(username.getText() + " " + password.getText());

        // 设置了一个管理员
        if(username.getText().equals("root")  && password.getText().equals("mima")) {
            new ChangeScene("rootScene.fxml");
        } else {
            // 判断用户名是否为空
            if(username.getText().equals("")) {
                prompt.setText("请输入用户名");
            } else {
                // 判断密码是否为空
                if(password.getText().equals("")) {
                    prompt.setText("请输入密码");
                } else {

                    // 排除以上情况
                    // 开始判断是否存在此用户
                    Connection con = GetDBConnection.connectDB("project", "root", "mima");
                    Statement stm = con.createStatement();

                    String  qname = "SELECT username from user where username=" + "'" + username.getText() + "'";
                    ResultSet re = stm.executeQuery(qname);
                    if(!re.next()) {
                        prompt.setText("用户不存在");
                    } else {
                        // 用户存在,验证密码，一般使用密码的hash比对,此次使用原密码
                        String qpwd = "SELECT password from user WHERE username = '" + username.getText() + "';";
                        ResultSet re2  = stm.executeQuery(qpwd);

                        // 密码错误
                        if(re2.next()) {
                            // getString()方法一定要在next()方法下运行，不然报错
                            if(!re2.getString(1).equals(password.getText()))
                                prompt.setText("密码错误");
                            else {
                                /*
                                密码正确，进入系统
                                 */
                                new ChangeScene("mainScene.fxml");
                             }
                        }

                    }




                }
            }







        }
    }

    public void ToRegister() throws IOException {
        new ChangeScene("register.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
