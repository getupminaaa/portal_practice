package kr.ac.jejunu.userdao;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetStatementStrategy(id);
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(user);

        jdbcContext.jdbcConetextForInsert(user, statementStrategy);
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContext.jdbcConetextForUpdate(statementStrategy);
    }

    public void delete(Integer id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcConetextForUpdate(statementStrategy);
    }


    private User jdbcContextForGet(StatementStrategy statementStrategy) throws SQLException {
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    private void jdbcConetextForInsert(User user, StatementStrategy statementStrategy) throws SQLException {
        jdbcContext.jdbcConetextForInsert(user, statementStrategy);
    }

    private void jdbcConetextForUpdate(StatementStrategy statementStrategy) throws SQLException {
        jdbcContext.jdbcConetextForUpdate(statementStrategy);
    }
}
