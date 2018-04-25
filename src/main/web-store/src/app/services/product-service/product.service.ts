import {Injectable} from '@angular/core';
import {url} from "../../configs"
import {Observable} from "rxjs/Observable";
import {JsonHttpResponse} from "../../models/json-http-response";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Product} from "../../models/product";

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) { }

  getProductById(productId: number): Observable<HttpResponse<JsonHttpResponse<Product>>> {
    return this.http.get<JsonHttpResponse<Product>>(
      url + "/products/" + productId,
      { withCredentials: true, observe: "response"}
    )
  }
}
