import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ReadingsService {

  constructor(private http: HttpClient) {}

  getReadings(): Observable<any[]> {
    return this.http.get(`http://localhost:8080/readings`)
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }

  getReadingsByVin(vehicleVin): Observable<any[]> {
    return this.http.get(`http://localhost:8080/readings/${vehicleVin}`)
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }
}
