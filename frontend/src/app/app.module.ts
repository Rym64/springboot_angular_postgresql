import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfilecitoyenComponent} from './profilecitoyen/profilecitoyen.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { FormuserComponent } from './cruduser/formuser/formuser.component';
import { ListcitoyenComponent } from './cruduser/listcitoyen/listcitoyen.component';
import { DemandepermisComponent } from './demandepermis/demandepermis.component';
import { Step2Component } from './stepdemandepermis/duplicatat/step2/step2.component';
import { Step3Component } from './stepdemandepermis/duplicatat/step3/step3.component';
import { Step4Component } from './stepdemandepermis/duplicatat/step4/step4.component';
import { Step4_2Component } from './stepdemandepermis/duplicatat/step4-2/step4-2.component';
import { Step4_3Component } from './stepdemandepermis/duplicatat/step4-3/step4-3.component';
import { Step4_4Component } from './stepdemandepermis/duplicatat/step4-4/step4-4.component';
import { Step4_5Component } from './stepdemandepermis/duplicatat/step4-5/step4-5.component';
import { Step4_6Component } from './stepdemandepermis/duplicatat/step4-6/step4-6.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    BoardModeratorComponent,
    ProfileComponent,
    ProfilecitoyenComponent,
    FormuserComponent,
    ListcitoyenComponent,
    DemandepermisComponent,
    Step2Component,
    Step3Component,
    Step4Component,
    Step4_2Component,
    Step4_3Component,
    Step4_4Component,
    Step4_5Component,
    Step4_6Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
