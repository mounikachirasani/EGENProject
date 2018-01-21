import { Component } from '@angular/core';
import {ReadingsService} from "../reading-service/readings.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-reading-list',
  templateUrl: './reading-list.component.html',
  styleUrls: ['./reading-list.component.css']
})
export class ReadingListComponent {
  readings;
  constructor(private route: ActivatedRoute, readingService: ReadingsService) {
    this.route.params.subscribe(params => {
      readingService.getReadingsByVin(params.id)
        .subscribe(
          readings => this.readings = readings,
          error => console.log(error));
    });
  }
}
