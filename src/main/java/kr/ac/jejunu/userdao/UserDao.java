package kr.ac.jejunu.userdao;

import java.sql.SQLException;

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
}
