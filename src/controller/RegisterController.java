package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import controller.ChangeScene;
import java.sql.PreparedStatement;

import java.io.IOException;

import java.sql.Connection;
import controller.sql.GetDBConnection;
import sun.security.provider.MD5;

public class RegisterController  {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repassword;

    @FXML
    private Label prompt;

    @FXML
    public void Register() throws Exception {
        // 查看是否以存在


        // 判断两次密码是否一致


        // 插入用户记录 !! 先测试是否有账号密码输入
        if(!username.getText().equals("") && !password.getText().equals("") && !repassword.getText().equals("")) {

            System.out.println("hello");
            Connection con = GetDBConnection.connectDB("project", "root", "mima");

            String sql = "INSERT INTO user VALUES(NULL,?,?,md5('" + password.getText() + "'));";  //可以md5
            // 本项目数据表包括密码的hash,也包含原密码（不安全），只为测试。

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, username.getText());
            pstm.setString(2, password.getText());

            pstm.executeUpdate();

            /*
                pstm.executeUpdate("truncate table user");
                这条命令用来情况表格，并且使主键自增归1.
             */



            prompt.setText("注册成功");
        } else {
            if(username.getText().equals("")) {
                prompt.setText("请输入用户名");
            } else{
                if(password.getText().equals("")) {
                    prompt.setText("请输入密码");
                } else {
                    prompt.setText("请确认密码");
                }
            }
        }

        // 测试
        System.out.println(username.getText() + "  " + password.getText());


    }

    @FXML
    public void ReturnLand() throws IOException {
        new ChangeScene("land.fxml");
    }


}
