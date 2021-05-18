import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfilecitoyenComponent} from './profilecitoyen/profilecitoyen.component';

import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { ListcitoyenComponent } from './cruduser/listcitoyen/listcitoyen.component';
import { FormuserComponent } from './cruduser/formuser/formuser.component';
import { DemandepermisComponent } from './demandepermis/demandepermis.component';
import { Step2Component } from './stepdemandepermis/duplicatat/step2/step2.component';
import { Step3Component } from './stepdemandepermis/duplicatat/step3/step3.component';
import { Step4Component } from './stepdemandepermis/duplicatat/step4/step4.component';
import { Step4_2Component } from './stepdemandepermis/duplicatat/step4-2/step4-2.component';
import { Step4_3Component } from './stepdemandepermis/duplicatat/step4-3/step4-3.component';
import { Step4_4Component } from './stepdemandepermis/duplicatat/step4-4/step4-4.component';
import { Step4_5Component } from './stepdemandepermis/duplicatat/step4-5/step4-5.component';
import { Step4_6Component } from './stepdemandepermis/duplicatat/step4-6/step4-6.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'profilecitoyen', component: ProfilecitoyenComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'listuser', component: ListcitoyenComponent },
  { path: 'form', component: FormuserComponent },
  { path: 'form/:id', component: FormuserComponent },
  { path: 'demandepermis', component: DemandepermisComponent },
  { path: 'step2', component: Step2Component },
  { path: 'step3', component: Step3Component },
  { path: 'step4', component: Step4Component },
  { path: 'step4-2', component: Step4_2Component },
  { path: 'step4-3', component: Step4_3Component },
  { path: 'step4-4', component: Step4_4Component },
  { path: 'step4-5', component: Step4_5Component },
  { path: 'step4-6', component: Step4_6Component },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
