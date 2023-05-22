package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;
@Repository
public class CarDaoImpl implements CarDao{
    @Autowired
    List<Car> cars;

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getNumCars(int num){
        return cars.stream().limit(num).toList();
    }
}
