package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {



    public User get(Integer id) throws ClassNotFoundException, SQLException {
        //data 어딨지?
        //mysql driver 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection 맺기
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/portalService?serverTimezone=UTC"
                , "root", "Rkdalsdk798!");
        //query 만들고
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from portal where id = ?");
        preparedStatement.setLong(1, id);
        // query 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //결과를 User 잘 매핑하고
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴
        return user;
    }


}
