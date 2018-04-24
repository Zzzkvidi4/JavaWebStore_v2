import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router"
import {LoginComponent} from "./login/login.component";
import {UserComponent} from "./user/user.component";
import {RegistrationComponent} from "./registration/registration.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "users/:userId", component: UserComponent },
  { path: "registration", component: RegistrationComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ],
  declarations: []
})
export class AppRoutingModule { }
