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

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { FormuserComponent } from './cruduser/formuser/formuser.component';
import { ListcitoyenComponent } from './cruduser/listcitoyen/listcitoyen.component';
import { ListcgComponent } from './crudcg/listcg/listcg.component';
import { FormcgComponent } from './crudcg/formcg/formcg.component';
import { ListCINComponent } from './crudCIN/list-cin/list-cin.component';
import { FormCINComponent } from './crudCIN/form-cin/form-cin.component';

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
    FormuserComponent,
    ListcitoyenComponent,
    ListcgComponent,
    FormcgComponent,
    ListCINComponent,
    FormCINComponent
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
