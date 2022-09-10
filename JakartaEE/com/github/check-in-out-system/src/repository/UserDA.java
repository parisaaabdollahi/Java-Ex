package repository;

import JDBD.JDBC;
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
        preparedStatement = connection.prepareStatement("select * from users where username=? and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return user.setRole(resultSet.getString("role"));
        throw new InvalidEmployeeCodeAndPassword();
    }

    public List<User> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from users ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User person = new User().setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setUsername(resultSet.getString("username")).setPassword(resultSet.getString("password")).setRole(resultSet.getString("role"));
            list.add(person);
        }
        return list;
    }

    public void insert(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into users (name ,family, username , password , role) values (?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getFamily());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.executeUpdate();
    }

    public void update(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("update users set name =? , family = ? , username=? , password= ? , role=?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getFamily());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.executeUpdate();
    }

    public void delete(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("delete users where username=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.executeUpdate();
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
