import {Injectable} from '@angular/core';
import {url} from "../../configs"
import {HttpClient, HttpResponse} from "@angular/common/http";
import {JsonHttpResponse} from "../../models/json-http-response";
import {ProductType} from "../../models/product-type";
import {Observable} from "rxjs/Observable";
import {Product} from "../../models/product";

@Injectable()
export class ProductTypeService {
  constructor(private http: HttpClient) { }

  getProductTypes(): Observable<HttpResponse<JsonHttpResponse<ProductType[]>>> {
    return this.http.get<JsonHttpResponse<ProductType[]>>(
      url + "/product_types",
      { withCredentials: true, observe: "response" }
      );
  }

  getProductsByProductTypeId(productTypeId: number): Observable<HttpResponse<JsonHttpResponse<Product[]>>> {
    return this.http.get<JsonHttpResponse<Product[]>>(
      url + "/product_types/" + productTypeId + "/products",
      { withCredentials: true, observe: "response" }
      );
  }

}
