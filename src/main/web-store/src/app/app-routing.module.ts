import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router"
import {LoginComponent} from "./login/login.component";
import {UserComponent} from "./user/user.component";
import {RegistrationComponent} from "./registration/registration.component";
import {ProductTypeComponent} from "./product-type/product-type.component";
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductComponent} from "./product/product.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "users/:userId", component: UserComponent },
  { path: "registration", component: RegistrationComponent },
  { path: "product_types", component: ProductTypeComponent },
  { path: "product_types/:productTypeId/products", component: ProductListComponent },
  { path: "product_types/:productTypeId/products/:productId", component: ProductComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ],
  declarations: []
})
export class AppRoutingModule { }
