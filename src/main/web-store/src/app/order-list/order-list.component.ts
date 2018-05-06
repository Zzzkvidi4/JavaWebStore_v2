import { Component, OnInit } from '@angular/core';
import {OrderService} from "../services/order-service/order.service";
import {Order} from "../models/order";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[] = null;

  constructor(
    private orderService: OrderService,
    private router: Router
  ) { }

  ngOnInit() {
    this.uploadOrders();
  }

  uploadOrders() {
    this.orderService.getAllOrders().subscribe(
      resp => {
        console.log(resp);
        this.orders = resp.body.data;
      },
      error => {
        console.log(error);
        if (error.status == 401) {
          this.router.navigate(["/login"]);
        }
      }
    )
  }
}
