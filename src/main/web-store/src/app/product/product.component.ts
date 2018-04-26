import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../services/product-service/product.service";
import {OrderService} from "../services/order-service/order.service";
import {Product} from "../models/product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product = null;
  count: number = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private orderService: OrderService
  ) { }

  ngOnInit() {
    this.uploadProduct();
  }

  uploadProduct(){
    let productId = +this.route.snapshot.paramMap.get("productId");
    this.productService.getProductById(productId).subscribe(resp => {
        console.log(resp);
        if (resp.status == 200) {
          this.product = resp.body.data;
        }
      }
    )
  }

  addToOrder(){

  }
}
