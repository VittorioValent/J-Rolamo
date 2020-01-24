import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { UserComponent } from './user/user.component';
import { WorkshopComponent } from './workshop/workshop.component';



const routes: Routes = [
  {
    path: 'admin-dashboard', component: AdminLayoutComponent, children: [
      {
       path: 'user', component: UserComponent
      },
      {
        path: 'workshop', component: WorkshopComponent
      }
    ]
  }   
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
