import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {UserComponent} from './user/user.component';
import {UserService} from "./services/user-service/user.service";
import {HttpClientModule} from "@angular/common/http";
import {LoginComponent} from './login/login.component';
import {FormsModule} from "@angular/forms";
import {RegistrationComponent} from './registration/registration.component';
import {ProductTypeComponent} from './product-type/product-type.component';
import {ProductComponent} from './product/product.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductTypeService} from "./services/product-type-service/product-type.service";
import {ProductTypeListComponent} from './product-type-list/product-type-list.component';
import {ProductService} from "./services/product-service/product.service";
import {OrderService} from "./services/order-service/order.service";
import {OrderListComponent} from './order-list/order-list.component';
import {OrderComponent} from './order/order.component';
import {MessagesComponent} from './messages/messages.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    RegistrationComponent,
    ProductTypeComponent,
    ProductComponent,
    ProductListComponent,
    ProductTypeListComponent,
    OrderListComponent,
    OrderComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    ProductTypeService,
    ProductService,
    OrderService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
