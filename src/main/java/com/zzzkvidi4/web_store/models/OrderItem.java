package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "order_items", schema = "web_store")
public class OrderItem {
    private int orderItemId;
    private int count;

    @Id
    @Column(name = "order_item_id")
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (orderItemId != orderItem.orderItemId) return false;
        return count == orderItem.count;
    }

    @Override
    public int hashCode() {
        int result = orderItemId;
        result = 31 * result + count;
        return result;
    }
}
