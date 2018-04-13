package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "product_param_values", schema = "web_store")
@IdClass(ProductParamValuePK.class)
public class ProductParamValue {
    @Id
    @Column(name = "product_id")
    private int productId;

    @Id
    @Column(name = "product_type_param_id")
    private int productTypeParamId;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false, insertable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductTypeParamId() {
        return productTypeParamId;
    }

    public void setProductTypeParamId(int productTypeParamId) {
        this.productTypeParamId = productTypeParamId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductParamValue that = (ProductParamValue) o;

        if (productId != that.productId) return false;
        if (productTypeParamId != that.productTypeParamId) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + productTypeParamId;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
