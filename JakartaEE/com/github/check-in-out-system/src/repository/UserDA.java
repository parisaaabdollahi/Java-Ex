package repository;

import JDBD.JDBC;
import entity.User;
import exception.invalidEmployeeCodeAndPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;


    public UserDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public User selectByEmployeeCodeAndPassword(User user) throws Exception {
        preparedStatement = connection.prepareStatement("select * from users where empcode=? and password=? ");
        preparedStatement.setString(1, user.getEmployeeCode());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return user.setRole(resultSet.getString("role"));
        throw new invalidEmployeeCodeAndPassword();
    }

    @Override
    public void close() throws Exception {

    }
}
