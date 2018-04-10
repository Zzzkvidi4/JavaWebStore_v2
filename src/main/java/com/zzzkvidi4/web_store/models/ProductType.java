package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "product_types", schema = "web_store")
public class ProductType {
    private int productTypeId;
    private String name;

    @Id
    @Column(name = "product_type_id")
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (productTypeId != that.productTypeId) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = productTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
