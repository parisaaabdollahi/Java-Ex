package repository;

import JDBD.JDBC;
import entity.Time;
import entity.User;
import exception.InvalidEmployeeCodeAndPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;


    public UserDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public User selectByEmployeeCodeAndPassword(User user) throws Exception {
        preparedStatement = connection.prepareStatement("select * from sys where username=? and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return user.setRole(resultSet.getString("role"));
        throw new InvalidEmployeeCodeAndPassword();
    }

    public List<User> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from sys order by id");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User().setId(resultSet.getLong("id")).setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setUsername(resultSet.getString("username")).setPassword(resultSet.getString("password")).setRole(resultSet.getString("role"));
            list.add(user);
        }
        return list;
    }

    public void insert(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("select sys_seq.nextval id from dual ");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getLong("id"));
        preparedStatement = connection.prepareStatement("insert into sys (id,name ,family, username , password , role) values (?,?,?,?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getFamily());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(5, user.getPassword());
        preparedStatement.setString(6, user.getRole());
        preparedStatement.executeUpdate();
    }

    public void update(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("update sys set name =? , family = ? , username=? , password= ? , role=? where id=?");

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getFamily());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setLong(6, user.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("delete sys where id=?");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.executeUpdate();
    }



    public void insertTime(User user , Time time) throws SQLException {
        preparedStatement = connection.prepareStatement("select time_seq.nextval id from dual ");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getLong("id"));
        preparedStatement= connection.prepareStatement("insert into time (id , username, login , logout) values (?,?,?,?)");
        preparedStatement.setLong(1,time.getId());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setLong(3,time.getLogin());
        preparedStatement.setLong(4,time.getLogout());
        preparedStatement.executeUpdate();
    }

    public List<Time> selectTime() throws SQLException {
        preparedStatement=connection.prepareStatement("select * from time order by id");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Time> timeList = new ArrayList<>();
        while (resultSet.next()){
            Time time = new Time().setId(resultSet.getLong("id")).setUsername(resultSet.getString("username")).setLogin(resultSet.getLong("login")).setLogout(resultSet.getLong("logout"));
            timeList.add(time);
        }
        return timeList;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
