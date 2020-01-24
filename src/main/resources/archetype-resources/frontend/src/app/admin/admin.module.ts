import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AdminRoutingModule } from './admin-routing.module';
import { UserComponent } from './user/user.component';
import { MatInputModule, MatTableModule, MatPaginatorModule, MatSortModule, MatProgressSpinnerModule, MatCardModule, MatRadioModule, MatSlideToggle, MatSlideToggleModule, MatSelectModule } from '@angular/material';
import { WorkshopComponent } from './workshop/workshop.component';
import { FormsModule, FormBuilder } from '@angular/forms';


@NgModule({
  declarations: [UserComponent, WorkshopComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatToolbarModule,
    FormsModule,
    MatCardModule,
    MatRadioModule,
    MatSlideToggleModule,
    MatSelectModule
  ],
  providers:[FormBuilder]
})
export class AdminModule { }
