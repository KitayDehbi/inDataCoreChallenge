import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarListComponent } from './cars/car-list/car-list.component';
import { DashboardComponent } from './cars/dashboard/dashboard.component';


const routes: Routes = [{ path: 'dashboard', component: DashboardComponent },
{ path: 'cars', component: CarListComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
