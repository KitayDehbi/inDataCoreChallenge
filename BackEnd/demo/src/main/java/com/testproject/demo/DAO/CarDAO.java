package com.testproject.demo.DAO;

import com.testproject.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDAO extends JpaRepository<Car, Long> {
    @Query(value = "select count(*) from car group by fuel" , nativeQuery = true)
    public List<Integer> getSumCarByFuel();
}
