import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { TasklistComponent } from './tasklist.component';

@NgModule({
  declarations: [TasklistComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [TasklistComponent]
})
export class TasklistModule { }
