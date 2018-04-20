package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "order_items", schema = "web_store")
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    private int orderItemId;

    @Column(name = "count")
    private int count;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false, insertable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, updatable = false, insertable = false)
    private Order order;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getCount() {
        return count;
    }

    public int getProductId() {
        return productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
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
