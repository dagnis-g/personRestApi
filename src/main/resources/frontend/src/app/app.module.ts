import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TableComponent } from './components/table/table.component';
import { FormsModule } from '@angular/forms';
import { DatePickerComponent } from './components/date-picker/date-picker.component';

@NgModule({
  declarations: [AppComponent, TableComponent, DatePickerComponent],
  imports: [BrowserModule, NgbModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
