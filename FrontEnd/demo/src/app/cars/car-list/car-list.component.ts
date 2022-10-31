import { Component, OnInit, ViewChild } from "@angular/core";
import { CarService } from "src/app/car.service";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";

export class Car {
  constructor(
    public id: number,
    public maker: string,
    public name: string,
    public horsePower: number,
    public fuel: string
  ) {}
}
@Component({
  selector: "app-car-list",
  templateUrl: "./car-list.component.html",
  styleUrls: ["./car-list.component.scss"],
})
export class CarListComponent implements OnInit {
  cars: Car[];
  car: Car = new Car(null, null, null, null, null);
  message: string = "";
  randomMessage: string = "";
  displayedColumns: string[] = ["ID", "MAKER", "NAME", "HORSE POWER", "FUEL"];
  dataSource = new MatTableDataSource<Car>();
  @ViewChild(MatPaginator, null) paginator: MatPaginator;

  constructor(private service: CarService) {}
  refreshCarList() {
    this.service.retrieveCarList().subscribe((response) => {
      this.dataSource = new MatTableDataSource<Car>(response);
      this.dataSource.paginator = this.paginator;
    });
  }
  addRandomCar() {
    this.service.addRandomCar().subscribe((response) => {
      //console.log(response);
      this.randomMessage = response;
      this.refreshCarList();
    });
  }

  addCar() {
    console.log(this.car.maker);
    console.log(this.car.name);
    console.log(this.car.horsePower);
    console.log(this.car.fuel);
    
    if (
      this.car.maker == null ||
      this.car.name == null ||
      this.car.horsePower == null ||
      this.car.fuel == null
    ) {
      this.message = "All field required";
    }else{
      this.service.addCar(this.car).subscribe((response) => {
        //console.log(response);
        this.message = "Car created Successfuly";
        this.car = new Car(null, null, null, null, null);
        this.refreshCarList();
      });
     
    }
  }
  ngOnInit() {
    this.refreshCarList();
  }
}
