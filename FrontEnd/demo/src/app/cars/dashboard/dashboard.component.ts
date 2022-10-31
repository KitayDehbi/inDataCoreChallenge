import { Component, OnInit } from "@angular/core";
import Chart from "chart.js/auto";
import { CarService } from "src/app/car.service";
@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.scss"],
})
export class DashboardComponent implements OnInit {
  public pieChart: any;
  public stackBarChart: any;
  pieData: number[] = [];
  stackBarChartData: number[] = [];
  constructor(private carService: CarService) {}

  ngOnInit() {
    this.carService.retrieveCarsSumByFuel().subscribe((res) => {
      console.log(res);
      res.forEach((element) => {
        this.pieData.push(element);
      });
    });
    this.createPieChart();
    this.createstackBarChart();
  }
  createPieChart() {
    this.pieChart = new Chart("pieChart", {
      type: "doughnut", //this denotes tha type of chart
      data: {
        // values on X-Axis
        labels: ["GASOILE", "DIESEL", "ELECTRIC"],
        datasets: [
          {
            label: "FUEL",
            data: this.pieData,
            backgroundColor: [
              "rgb(255, 99, 132)",
            ],
          },
        ],
      },
      options: {
        aspectRatio: 2.5,
      },
    });
  }
  createstackBarChart() {
    this.stackBarChart = new Chart("stackBarChart", {
      type: "line", //this denotes tha type of chart

      data: {
        // values on X-Axis
        labels: ["GASOILE", "DIESEL", "ELECTRIC"],
        datasets: [
          {
            label: "FUEL",
            data: this.pieData,
            backgroundColor: "blue",
          },
        ],
      },
      options: {
        aspectRatio: 2.5,
      },
    });
  }
}
