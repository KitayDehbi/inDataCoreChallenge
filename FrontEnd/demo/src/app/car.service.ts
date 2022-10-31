import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Car } from './cars/car-list/car-list.component';
import { Options } from 'selenium-webdriver';

const URL = "http://localhost:8080/api/cars/"
@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }
  
  retrieveCarList() {
    return this.http.get<Car[]>(URL +"list");
  }
  addRandomCar() {
    return this.http.post(URL +"createRandomCar",{},{responseType: 'text'});
  } 
  addCar(car) {
    return this.http.post(URL +"create",car);
  }
  retrieveCarsSumByFuel() {
    return this.http.get<number[]>(URL +"carsByFuel");
  }
}
