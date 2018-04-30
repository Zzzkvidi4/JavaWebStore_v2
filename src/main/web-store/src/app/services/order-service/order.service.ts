import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderItem} from "../../models/order-item";
import { url } from "../../configs"
import {JsonHttpResponse} from "../../models/json-http-response";
import {HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../../models/order";

@Injectable()
export class OrderService {

  constructor(private http: HttpClient) { }

  createOrderItem(item: OrderItem): Observable<HttpResponse<JsonHttpResponse<any>>>{
    return this.http.post<JsonHttpResponse<any>>(
      url + "/order_items",
      item,
      {withCredentials: true, observe: "response"}
    );
  }

  deleteOrderItem(orderItemId: number): Observable<HttpResponse<JsonHttpResponse<any>>> {
    return this.http.delete<JsonHttpResponse<any>>(
      url + "/order_items/" + orderItemId,
      {withCredentials: true, observe: "response"}
    );
  }

  getAllOrders(): Observable<HttpResponse<JsonHttpResponse<Order[]>>> {
    return this.http.get<JsonHttpResponse<Order[]>>(
      url + "/orders",
      {withCredentials: true, observe: "response"}
    );
  }

  getOrderById(orderId: number): Observable<HttpResponse<JsonHttpResponse<Order>>> {
    return this.http.get<JsonHttpResponse<Order>>(
      url + "/orders/" + orderId,
      {withCredentials: true, observe: "response"}
    );
  }

  closeOrder(orderId: number): Observable<HttpResponse<JsonHttpResponse<any>>> {
    return this.http.put<JsonHttpResponse<any>>(
      url + "/orders/" + orderId,
      null,
      {withCredentials: true, observe: "response"}
    );
  }
}
