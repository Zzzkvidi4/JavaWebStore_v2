import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from "../services/product-type-service/product-type.service";
import {ActivatedRoute} from "@angular/router";
import {Product} from "../models/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = null;

  constructor(
    private productTypeService: ProductTypeService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.uploadProducts();
  }

  uploadProducts(){
    let productTypeId = +this.route.snapshot.paramMap.get("productTypeId");
    this.productTypeService.getProductsByProductTypeId(productTypeId).subscribe(resp => {
      console.log(resp);
      if (resp.status == 200) {
        this.products = resp.body.data;
      }
    })
  }
}
