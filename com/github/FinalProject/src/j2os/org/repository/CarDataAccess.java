package j2os.org.repository;

import j2os.org.common.JDBC;
import j2os.org.domain.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDataAccess implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarDataAccess() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Car car) throws Exception {
        preparedStatement = connection.prepareStatement("select car_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        car.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into car (id,model,code,indoor,outdoor,cast) values (?,?,?,?,?,?)");
        preparedStatement.setLong(1, car.getId());
        preparedStatement.setString(2, car.getModel());
        preparedStatement.setString(3, car.getCode());
        preparedStatement.setInt(4, car.getInDoor());
        preparedStatement.setInt(5, car.getOutDoor());
        preparedStatement.setLong(6, car.getCost());
        preparedStatement.executeUpdate();
    }

    public List<Car> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from car ");
        List<Car> carList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        Car car = null;
        while (resultSet.next()) {
            car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setModel(resultSet.getString("model"));
            car.setCode(resultSet.getString("code"));
            car.setInDoor(resultSet.getInt("indoor"));
            car.setOutDoor((resultSet.getInt("outdoor")));
            car.setCost(resultSet.getLong("cast"));
            carList.add(car);
        }
        return carList;
    }

    public List<Car> selectByCode(String code) throws Exception {
        preparedStatement = connection.prepareStatement("select * from car where code=?");
        preparedStatement.setString(1, code);
        List<Car> carList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        Car car = null;
        while (resultSet.next()) {
            car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setModel(resultSet.getString("model"));
            car.setCode(resultSet.getString("code"));
            car.setInDoor(resultSet.getInt("indoor"));
            car.setOutDoor((resultSet.getInt("outdoor")));
            car.setCost(resultSet.getLong("cast"));
            carList.add(car);
        }
        return carList;
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
