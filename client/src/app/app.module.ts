import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {VehicleService} from './vehicle-service/vehicle.service';
import {VehicleListComponent} from './vehicle-list/vehicle-list.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { ReadingListComponent } from './reading-list/reading-list.component';
import {ReadingsService} from './reading-service/readings.service';
import { AlertListComponent } from './alerts-list/alerts-list.component';
import {AlertsService} from "./alerts-service/alerts.service";


const appRoutes: Routes = [
  {path: 'vehicles' , component: VehicleListComponent},
  {path: 'vehicles/:id' , component: VehicleDetailsComponent},
  {path: 'vehicles/:id/alerts/:id', component: AlertListComponent},
  {path: 'vehicles/:id/readings/:id', component: ReadingListComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleDetailsComponent,
    ReadingListComponent,
    AlertListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleService, ReadingsService, AlertsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
