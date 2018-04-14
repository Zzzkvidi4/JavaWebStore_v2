package com.zzzkvidi4.web_store.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_types", schema = "web_store")
public class ProductType {
    @Id
    @Column(name = "product_type_id")
    private int productTypeId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productType")
    private Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy = "")
    private Set<ProductTypeParam> paramTypes = new HashSet<>();

    public Set<Product> getProducts() {
        return products;
    }

    public Set<ProductTypeParam> getParamTypes() {
        return paramTypes;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

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
