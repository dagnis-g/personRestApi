import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { DatePickerComponent } from './components/date-picker/date-picker.component';
import { Person } from './shared/model/person.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  @ViewChild(DatePickerComponent) child!: DatePickerComponent;
  title = 'frontend';
  personalId: string = '';
  dateOfBirth: string = '';
  person: Person | undefined;
  persons: Person[] = [];
  errorMessage: string = '';

  private isNotInArray(personalId: string): boolean {
    return !this.persons.some((p) => p.personalId === personalId);
  }

  constructor(private http: HttpClient) {}

  onDateSelect($event: string): void {
    this.dateOfBirth = $event;
  }

  onInput(value: string): void {
    this.personalId = value;
  }

  sendGetReq(): void {
    if (!this.dateOfBirth) {
      this.errorMessage = 'No date selected';
      return;
    }

    let params = { personalId: this.personalId, dateOfBirth: this.dateOfBirth };

    this.http
      .get<Person>('http://localhost:8080/find', { params })
      .pipe(
        catchError((error) => {
          this.errorMessage = error.error.message;
          return throwError(() => new Error(error.error.message));
        })
      )
      .subscribe((resp) => {
        this.errorMessage = '';
        if (this.isNotInArray(resp.personalId)) {
          this.persons.push(resp);
        } else {
          this.errorMessage = 'Person already in table';
        }
      });
    this.personalId = '';
    this.child.selectedDate = undefined;
  }
}
