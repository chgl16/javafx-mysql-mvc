package controller.sql;

import java.sql.*;

public class GetDBConnection {

    public static Connection connectDB(String DBName, String user, String password) throws SQLException, ClassNotFoundException {

        Connection con = null;

        // 反射加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/" + DBName + "?useSSL=true&characterEncoding=utf-8";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
