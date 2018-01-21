import { Component} from '@angular/core';
import {AlertsService} from '../alerts-service/alerts.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-alert-list',
  templateUrl: './alerts-list.component.html',
  styleUrls: ['./alerts-list.component.css']
})
export class AlertListComponent {
  alerts;
  constructor(private route: ActivatedRoute, alertService: AlertsService) {
    this.route.params.subscribe(params => {
      alertService.getAllAlertsByVin(params.id)
        .subscribe(
          alerts => this.alerts = alerts,
          error => console.log(error)
    );
    });
  }
}

