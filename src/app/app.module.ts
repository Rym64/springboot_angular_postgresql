import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { UserserviceService } from './services/userservice.service';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserFormComponent } from './userform/userform.component';
import { ListuserComponent } from './listuser/listuser.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistreComponent } from './registre/registre.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AuthComponent,
    UserFormComponent,
    ListuserComponent,
    ProfileComponent,
    RegistreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
