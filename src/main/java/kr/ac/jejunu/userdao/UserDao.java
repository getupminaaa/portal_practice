package kr.ac.jejunu.userdao;

import java.sql.*;

public abstract class UserDao {
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        //data 어딨지?
        //mysql driver 로딩
        Connection connection = getConnection();
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

    public void insert(User user) throws ClassNotFoundException, SQLException {
        //data 어딨지?
        //mysql driver 로딩
        Connection connection = getConnection();
        //query 만들고
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into portal(name,password) value (?,?)",Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        // query 실행하고
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();

        user.setId(resultSet.getInt(1));
        //결과를 User 잘 매핑하고

        //자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴
    }

    abstract public Connection getConnection() throws ClassNotFoundException, SQLException;

}
