import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../services/product-service/product.service";
import {OrderService} from "../services/order-service/order.service";
import {Product} from "../models/product";
import {OrderItem} from "../models/order-item";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product = null;
  count: number = 1;
  productId: number;
  messages: string[];

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private orderService: OrderService,
    private router: Router
  ) { }

  ngOnInit() {
    this.productId = +this.route.snapshot.paramMap.get("productId");
    this.uploadProduct();
  }

  uploadProduct(){
    this.productService.getProductById(this.productId).subscribe(resp => {
        console.log(resp);
        if (resp.status == 200) {
          this.product = resp.body.data;
        }
      }
    )
  }

  addToOrder(){
    if (this.isCountValid()) {
      let item = new OrderItem();
      item.productId = this.productId;
      item.count = this.count;
      let tmp = this.orderService.createOrderItem(item);
      tmp.subscribe(resp => {
        if (resp.body.errors.length == 0) {
          this.router.navigate(["/product_types"]);
        } else {
          this.messages = resp.body.errors;
        }
      }, error => {
        if (error.status == 401) {
          this.router.navigate(["/login"]);
        }
      });
    } else {
      this.messages = ["Product count should be between 1 and " + this.product.count + "!"]
    }
  }

  isCountValid(){
    return ((this.count > 0) && (this.count <= this.product.count));
  }
}
