import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../services/product-service/product.service";
import {Product} from "../models/product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  private product: Product = null;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
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
}
