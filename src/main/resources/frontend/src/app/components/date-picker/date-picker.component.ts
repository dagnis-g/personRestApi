import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-date-picker',
  templateUrl: './date-picker.component.html',
  styleUrls: ['./date-picker.component.css'],
})
export class DatePickerComponent {
  @Output() dateOfBirthEmiter = new EventEmitter<string>();

  selectedDate: NgbDateStruct | undefined;
  dateOfBirth: string = '';
  now: Date = new Date();
  maxDate: NgbDateStruct = {
    year: this.now.getFullYear(),
    month: this.now.getMonth(),
    day: this.now.getDate(),
  };

  onDateSelect(event: NgbDateStruct): void {
    this.dateOfBirth = `${this.padZero(event.year)}-${this.padZero(
      event.month
    )}-${this.padZero(event.day)}`;

    this.dateOfBirthEmiter.emit(this.dateOfBirth);
  }

  private padZero(value: number): string {
    return value.toString().padStart(2, '0');
  }
}
