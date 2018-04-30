import { Component, OnInit } from '@angular/core';
import {OrderService} from "../services/order-service/order.service";
import {Router, ActivatedRoute} from "@angular/router";
import {Order} from "../models/order";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  private orderId: number;
  private order: Order = null;
  constructor(
    private orderService: OrderService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.orderId = +this.route.snapshot.paramMap.get("orderId");
    this.uploadOrder();
  }

  uploadOrder() {
    this.orderService.getOrderById(this.orderId).subscribe(
      resp => {
        console.log(resp);
        this.order = resp.body.data;
      },
      error => {
        console.log(error);
        if (error.status == 401) {
          this.router.navigate(["/login"]);
        }
      }
    )
  }

  closeOrder(){
    this.orderService.closeOrder(this.orderId).subscribe(
      resp => {
        console.log(resp);
        this.router.navigate(["/orders"])
      },
      error => {
        console.log(error);
        if (error.status == 401) {
          this.router.navigate(["/login"])
        }
      }
    )
  }

  deleteOrderItem(orderItemId: number){
    this.orderService.deleteOrderItem(orderItemId).subscribe(
      resp => {
        console.log("Delete order item: ");
        console.log(resp);
        this.router.navigate(["/orders/" + this.orderId]);
      },
      error => {
        console.log("Error while deleting order item: " + error);
        this.router.navigate(["/login"]);
      }
    )
  }
}
