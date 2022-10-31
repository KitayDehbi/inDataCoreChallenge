package com.testproject.demo.configuration;

import com.testproject.demo.DAO.CarDAO;
import com.testproject.demo.domain.Car;
import com.testproject.demo.domain.Fuel;
import com.testproject.demo.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    CommandLineRunner commandLineRunner(CarDAO carDAO){
        return args -> {
            Resource resource = new ClassPathResource("data.csv");
            Scanner sc = new Scanner(resource.getFile());
            sc.useDelimiter("\n");
            List<Car> list = new ArrayList<>();//sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                Car c = CarService.getCarFromLine(sc.next());
                list.add(c);
            }
            sc.close();
           carDAO.saveAll(list);
        };
    }
}
