package j2os.org.repository;

import j2os.org.common.JDBC;
import j2os.org.domain.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBC.getConnection();

    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select personal_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into personal (id,name,family) values (?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update personal set name=? , family=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getId());
        preparedStatement.executeUpdate();

    }

    public void delete(long id) throws Exception {
        preparedStatement = connection.prepareStatement("delete from personal where id =?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();

    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from personal ");
        List<Person> personList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            personList.add(person);

        }
        return personList;
    }

    public Person selectById(long id) throws Exception{
        preparedStatement = connection.prepareStatement("select * from personal where id= ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = null;
        if (resultSet.next()) {
            person = new Person();
            person.setId(id);
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));

        }
        return person;
    }
    public List<Person> selectByName(String name) throws Exception {
        preparedStatement = connection.prepareStatement("select * from personal where name = ?");
        preparedStatement.setString(1, name);
        List<Person> personList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            personList.add(person);

        }
        return personList;
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
