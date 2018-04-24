import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from "../services/product-type-service/product-type.service";
import {ProductType} from "../models/product-type";

@Component({
  selector: 'app-product-type-list',
  templateUrl: './product-type-list.component.html',
  styleUrls: ['./product-type-list.component.css']
})
export class ProductTypeListComponent implements OnInit {
  productTypes: ProductType[] = null;
  constructor(private productTypeService: ProductTypeService) { }

  ngOnInit() {
    this.uploadProductTypes();
  }

  uploadProductTypes(){
    this.productTypeService.getProductTypes().subscribe(resp => {
      console.log(resp);
      if (resp.status == 200) {
        this.productTypes = resp.body.data;
      }
    })
  }
}
