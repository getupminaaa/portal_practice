package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "hulk";
    String password = "1234";
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;

        ConnectionMaker connectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnectionMaker connectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        userDao.insert(user);

        User insertedUser = userDao.get(user.getId());

        assertThat(user.getId(),greaterThan(0));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
    @Test
    public void testGetHalla() throws SQLException, ClassNotFoundException {
        Integer id = 1;


        ConnectionMaker connectionMaker = new HallConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void testInsertHalla() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnectionMaker connectionMaker = new HallConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        userDao.insert(user);

        User insertedUser = userDao.get(user.getId( ));

        assertThat(user.getId(),greaterThan(0));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

}
