package j2os.org.repository;

import j2os.org.common.JDBC;
import j2os.org.entity.Person;
import j2os.org.error.SinError;
import j2os.org.service.SINValidation;
//import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDataAccess implements AutoCloseable {
    private Connection connection;
   private PreparedStatement preparedStatement;

    public PersonDataAccess() throws Exception {
        connection = JDBC.getConnection();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            person.setSin(resultSet.getLong("sin"));
            personList.add(person);
        }
        return personList;
    }

    public Person selectById(long id) throws Exception {
        preparedStatement = connection.prepareStatement("select * from person where id= ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = null;
        if (resultSet.next()) {
            person = new Person();
            person.setId(id);
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            person.setSin(resultSet.getLong("sin"));
        }
        return person;
    }

    public void insert(Person person) throws Exception, SinError {
        preparedStatement = connection.prepareStatement("insert into person (id,name,family,sin) values(?,?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setLong(4, person.getSin());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set name=?,family=?,sin=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getSin());
        preparedStatement.setLong(4, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public void commit() throws Exception {
        connection.commit();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}


