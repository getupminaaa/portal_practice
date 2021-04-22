package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HallaUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection 맺기
        return DriverManager.getConnection("jdbc:mysql://localhost/portalService?serverTimezone=UTC"
                , "root", "Rkdalsdk798!");
    }
}
