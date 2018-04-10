package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "web_store")
public class Product {
    private int productId;
    private String name;
    private int count;
    private int price;
    private ProductType productTypesByProductTypeId;
    private Country countriesByCountryId;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "price")
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

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (count != product.count) return false;
        if (price != product.price) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + price;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id", nullable = false)
    public ProductType getProductTypesByProductTypeId() {
        return productTypesByProductTypeId;
    }

    public void setProductTypesByProductTypeId(ProductType productTypesByProductTypeId) {
        this.productTypesByProductTypeId = productTypesByProductTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    public Country getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(Country countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}
