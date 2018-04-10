package com.zzzkvidi4.web_store.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProductParamValuePK implements Serializable {
    private int productId;
    private int productTypeParamId;

    @Column(name = "product_id")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "product_type_param_id")
    @Id
    public int getProductTypeParamId() {
        return productTypeParamId;
    }

    public void setProductTypeParamId(int productTypeParamId) {
        this.productTypeParamId = productTypeParamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductParamValuePK that = (ProductParamValuePK) o;

        if (productId != that.productId) return false;
        return productTypeParamId == that.productTypeParamId;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + productTypeParamId;
        return result;
    }
}
