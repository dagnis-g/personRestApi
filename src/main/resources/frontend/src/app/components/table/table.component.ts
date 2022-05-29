import { Component, Input, OnInit } from '@angular/core';
import { Person } from 'src/app/shared/model/person.model';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  @Input() persons: Person[] = [];

  constructor() {}

  ngOnInit(): void {}
}
