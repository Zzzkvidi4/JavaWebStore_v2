import {OrderItem} from "./order-item";
import {Status} from "./status";
/**
 * Created by Роман on 26.04.2018.
 */
export class Order{
  orderId: number;
  date: Date;
  price: number;
  items: OrderItem[];
  status: Status;
}
