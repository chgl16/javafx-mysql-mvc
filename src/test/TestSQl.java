package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.sql.GetDBConnection;



public class TestSQl {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        String DBName = "user";
        String user = "root";
        String password = "mima";

        Connection con = GetDBConnection.connectDB(DBName, user, password);

        Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet re = sql.executeQuery("SELECT * FROM usemanger");

        String sml = "insert into  values(?,21,20050)"; //
        PreparedStatement pstm = con.prepareStatement(sml); //
        pstm.setString(1, "lin"); //
        pstm.executeUpdate();  //

        // 等价与前面三句
        pstm.executeUpdate("insert into usemanger values('guan', 22, 30000)");

        //re.last();

        while(re.next()) {
            System.out.println("hello");
            System.out.println(re.getString(2));
        }


    }

}
