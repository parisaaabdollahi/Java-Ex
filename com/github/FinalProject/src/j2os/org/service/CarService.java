package j2os.org.service;

import j2os.org.domain.Car;
import j2os.org.repository.CarDataAccess;

import java.util.List;

public class CarService {
    private CarService(){}
    private static CarService carService= new CarService();
    public static CarService getInstance(){
        return carService;
    }

public void save(Car car) throws Exception {
        try(CarDataAccess carDataAccess=new CarDataAccess()){
car.setCost(TimeCheckCost.CalculateCost(car.getInDoor(),car.getOutDoor()));
            carDataAccess.insert(car);
            carDataAccess.commit();
        }
}


public List<Car> findByCode(String code) throws Exception {
        try(CarDataAccess carDataAccess=new CarDataAccess()){
            return carDataAccess.selectByCode(code);
        }
}

    public List<Car> findAll() throws Exception {
        try(CarDataAccess carDataAccess=new CarDataAccess()){
            return carDataAccess.selectAll();
        }
    }
}
