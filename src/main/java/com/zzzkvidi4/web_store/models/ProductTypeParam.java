package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "product_type_params", schema = "web_store")
public class ProductTypeParam {
    private int productTypeParamId;
    private String name;
    private String type;
    private String comment;
    private byte isOptional;

    @Id
    @Column(name = "product_type_param_id")
    public int getProductTypeParamId() {
        return productTypeParamId;
    }

    public void setProductTypeParamId(int productTypeParamId) {
        this.productTypeParamId = productTypeParamId;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "is_optional")
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
