import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AlertsService {

  constructor(private http: HttpClient) { }

  getAllAlerts(): Observable<any[]> {
    console.log('alerts');
    return this.http.get('assets/alerts.json')
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }

  getAllAlertsByVin(vin): Observable<any[]> {
    console.log('Hello World' + vin);
    return this.http.get(`http://localhost:8080/alerts/time/${vin}`)
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }
}
