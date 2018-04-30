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
    let item = new OrderItem();
    item.productId = this.productId;
    item.count = this.count;
    let tmp = this.orderService.createOrderItem(item);
    tmp.subscribe(resp => {
      this.router.navigate(["/product_types"]);
    }, error => {
      if (error.status == 401) {
        this.router.navigate(["/login"]);
      }
    });
  }
}
