package com.zzzkvidi4.web_store.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "web_store")
public class Order {
    @Id
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "price")
    private int price;

    @Column(name = "user_id")
    private int userId;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (price != order.price) return false;
        return date != null ? date.equals(order.date) : order.date == null;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
