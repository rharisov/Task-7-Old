package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;

    public List<Car> getNumCars(int num){
        return carDao.getNumCars(num);
    }

    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }
}
