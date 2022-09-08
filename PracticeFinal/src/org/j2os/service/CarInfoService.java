package org.j2os.service;

import org.j2os.entity.CarInfo;
import org.j2os.repository.CarInfoDa;

import java.util.List;

public class CarInfoService {
    private static CarInfoService CAR_INFO_SERVICE = new CarInfoService();

    private CarInfoService() {
    }

    public static CarInfoService getInstance() {
        return CAR_INFO_SERVICE;
    }

    public void add(CarInfo carInfo) throws Exception {
        try (CarInfoDa CarDa = new CarInfoDa()) {
            if (carInfo.getOutdoor() >= 7 && carInfo.getOutdoor() < 10) {
                carInfo.setCost(12000L);
            } else if (carInfo.getOutdoor() >= 10 && carInfo.getOutdoor() < 12) {
                List<CarInfo> carInfoList = findAll(carInfo.getCode(), 10, 12);
                if (carInfoList.size() < 2)
                    carInfo.setCost(10000L);
            } else if (carInfo.getOutdoor() >= 12 && carInfo.getOutdoor() < 17) {
                carInfo.setCost(5000L);
            } else {
                carInfo.setCost(0L);
            }
            CarDa.insert(carInfo);
            CarDa.commit();
        }
    }


    public List<CarInfo> findAll(String code) throws Exception {
        try (CarInfoDa carInfoDa = new CarInfoDa()) {
            return carInfoDa.list(code);
        }
    }

    public List<CarInfo> findAll(String code, int indoor, int outdoor) throws Exception {
        try (CarInfoDa carInfoDa = new CarInfoDa()) {
            return carInfoDa.list(code, indoor, outdoor);
        }
    }
}
