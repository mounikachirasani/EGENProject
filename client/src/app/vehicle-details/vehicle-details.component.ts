import { Component } from '@angular/core';
import {VehicleService} from '../vehicle-service/vehicle.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent {
  vehicle;
  constructor(private route: ActivatedRoute, vehicleService: VehicleService) {
    this.route.params.subscribe(params => {
      vehicleService.getVehiclebyVin(params.id)
        .subscribe(vehicle => this.vehicle = vehicle);
    });
  }
}
