package com.testproject.demo.service;

import com.testproject.demo.DAO.CarDAO;
import com.testproject.demo.domain.Car;
import com.testproject.demo.domain.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class CarService {
    private CarDAO carDAO;

    public List<Car> getAllCars(){
        return carDAO.findAll();
    }

    public void saveCar(Car car) {
        carDAO.save(car);
    }

    public void saveCar() throws IOException {
        Resource resource = new ClassPathResource("randomData.csv");
        Scanner sc = new Scanner(resource.getFile());
        sc.useDelimiter("\n");
        List<Car> list = new ArrayList<>();
        while (sc.hasNext()){
            Car c = getCarFromLine(sc.next());
            list.add(c);
        }
        Random r = new Random();
        Car randomCar =  list.stream().skip(r.nextInt(list.size())).findFirst().get();
        carDAO.save(randomCar);



    }
    public  List<Integer> getSumCarsByFuel(){
        return this.carDAO.getSumCarByFuel();
    }

    public static Car getCarFromLine(String line) {

        String[] tmp = line.split(",");
        Car c = new Car();
        c.setMaker(tmp[0]);
        c.setName(tmp[1]);
        c.setHorsePower(Integer.parseInt(tmp[2]));
        c.setFuel(Fuel.valueOf(tmp[3].trim()));
        return c;
    }


}
