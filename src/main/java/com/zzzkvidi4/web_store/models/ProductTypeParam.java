package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "product_type_params", schema = "web_store")
public class ProductTypeParam {
    @Id
    @Column(name = "product_type_param_id")
    private int productTypeParamId;

    @Column(name = "product_type_id")
    private int productTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_optional")
    private byte isOptional;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false, updatable = false, insertable = false)
    private ProductType productType;

    public int getProductTypeId() {
        return productTypeId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getProductTypeParamId() {
        return productTypeParamId;
    }

    public void setProductTypeParamId(int productTypeParamId) {
        this.productTypeParamId = productTypeParamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(byte isOptional) {
        this.isOptional = isOptional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductTypeParam that = (ProductTypeParam) o;

        if (productTypeParamId != that.productTypeParamId) return false;
        if (isOptional != that.isOptional) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return (type != null ? type.equals(that.type) : that.type == null) && (comment != null ? comment.equals(that.comment) : that.comment == null);
    }

    @Override
    public int hashCode() {
        int result = productTypeParamId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (int) isOptional;
        return result;
    }
}
