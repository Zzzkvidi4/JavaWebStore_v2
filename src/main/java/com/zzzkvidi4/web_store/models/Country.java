package com.zzzkvidi4.web_store.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries", schema = "web_store")
public class Country {
    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Product> products = new HashSet<>();

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        return name != null ? name.equals(country.name) : country.name == null;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
