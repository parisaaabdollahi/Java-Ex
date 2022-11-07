package org.j2os.service;

import org.j2os.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class CarService {
    @Autowired
    private GenericDA<Car,Long> genericDA;

@Transactional
    public void save(Car car){genericDA.save(car);}
}
