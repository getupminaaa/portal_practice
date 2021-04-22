package kr.ac.jejunu.userdao;

import java.sql.SQLException;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Object[] parms = new Object[]{id};
        String sql = "select * from portal where id = ?";
        return jdbcContext.get(sql, parms);
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        Object[] parms = new Object[]{user.getName(), user.getPassword()};
        String sql = "insert into portal(name,password) value (?,?)";

        jdbcContext.insert(user, parms, sql);
    }

    public void update(User user) throws SQLException {
        Object[] parms = new Object[]{user.getName(), user.getPassword(), user.getId()};
        String sql = "update portal set name = ?, password = ? where id =?";
        jdbcContext.update(sql, parms);
    }

    public void delete(Integer id) throws SQLException {
        Object[] parms = new Object[]{id};
        String sql = "delete from portal where id =?";
        jdbcContext.update(sql, parms);
    }

}
