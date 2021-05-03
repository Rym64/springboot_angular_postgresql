import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { ListcitoyenComponent } from './cruduser/listcitoyen/listcitoyen.component';
import { FormuserComponent } from './cruduser/formuser/formuser.component';
import { ListcgComponent } from './crudcg/listcg/listcg.component';
import { FormcgComponent } from './crudcg/formcg/formcg.component';
import { ListCINComponent } from './crudCIN/list-cin/list-cin.component';
import { FormCINComponent } from './crudCIN/form-cin/form-cin.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'citoyen', component: BoardUserComponent },
  { path: 'agent', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'listuser', component: ListcitoyenComponent },
  { path: 'form', component: FormuserComponent },
  { path: 'form/:id', component: FormuserComponent },
  { path: 'listcg', component: ListcgComponent },
  { path: 'formcg', component: FormcgComponent },
  { path: 'listcin', component: ListCINComponent },
  { path: 'formcin', component: FormCINComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
