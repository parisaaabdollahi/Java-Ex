package org.j2os.repository;
import org.j2os.common.JDBC;
import org.j2os.entity.CarInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class CarInfoDa implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarInfoDa() throws Exception {
        connection = JDBC.getConnection();
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

    public void insert(CarInfo carInfo) throws Exception {
        preparedStatement = connection.prepareStatement("insert into car_info (id,model,code,indoor,outdoor,cost) values (car_info_seq.nextval,?,?,?,?,?)");
        preparedStatement.setString(1, carInfo.getModel());
        preparedStatement.setString(2, carInfo.getCode());
        preparedStatement.setInt(3, carInfo.getIndoor());
        preparedStatement.setInt(4, carInfo.getOutdoor());
        preparedStatement.setLong(5, carInfo.getCost());
        preparedStatement.executeUpdate();
    }


    public List<CarInfo> list(String code) throws Exception {
        preparedStatement = connection.prepareStatement("select * from car_info where code=?");
        preparedStatement.setString(1, code);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarInfo> returnValue = new ArrayList<>();
        while (resultSet.next()) {
            CarInfo carInfo = new CarInfo();
            carInfo.setId(resultSet.getLong("id"));
            carInfo.setModel(resultSet.getString("model"));
            carInfo.setCode(resultSet.getString("code"));
            carInfo.setIndoor(resultSet.getInt("indoor"));
            carInfo.setOutdoor(resultSet.getInt("outdoor"));
            carInfo.setCost(resultSet.getLong("cost"));
            returnValue.add(carInfo);
        }
        return returnValue;
    }

    public List<CarInfo> list(String code, int indoor, int outdoor) throws Exception {
        preparedStatement = connection.prepareStatement("select * from car_info where code=? and outdoor>=? and outdoor<=? ");
        preparedStatement.setString(1, code);
        preparedStatement.setInt(2, indoor);
        preparedStatement.setInt(3, outdoor);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarInfo> returnValue = new ArrayList<>();
        while (resultSet.next()) {
            CarInfo carInfo = new CarInfo();
            carInfo.setId(resultSet.getLong("id"));
            carInfo.setModel(resultSet.getString("model"));
            carInfo.setCode(resultSet.getString("code"));
            carInfo.setIndoor(resultSet.getInt("indoor"));
            carInfo.setOutdoor(resultSet.getInt("outdoor"));
            carInfo.setCost(resultSet.getLong("cost"));
            returnValue.add(carInfo);
        }
        return returnValue;
    }
}
