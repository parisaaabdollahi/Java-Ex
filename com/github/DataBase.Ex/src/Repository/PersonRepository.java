package Repository;

import Entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

private Connection connection;
private PreparedStatement preparedStatement;

public PersonRepository() throws Exception {
 Class.forName("oracle.jdbc.driver.OracleDriver");
connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "parisa", "java123");
}

public void insert(Person person)throws Exception{
preparedStatement=connection.prepareStatement("insert into person (id,name,family) values (?,?,?)");
preparedStatement.setLong(1,person.getId());
preparedStatement.setString(2,person.getName());
preparedStatement.setString(3,person.getFamily());
preparedStatement.executeUpdate();

}

public List<Person> selectAll() throws Exception{
preparedStatement=connection.prepareStatement("select * from person");
    ResultSet resultSet=preparedStatement.executeQuery();
List<Person> personList=new ArrayList<>();
while (resultSet.next()){
Person person=new Person().setId(resultSet.getLong("id")).setName(resultSet.getString("name")).setFamily(resultSet.getString("family"));
personList.add(person);
}
return personList;
}

public void close() throws Exception{
preparedStatement.close();
connection.close();
}

}
