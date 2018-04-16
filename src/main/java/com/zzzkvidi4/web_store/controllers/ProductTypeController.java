package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.models.ProductType;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.HibernateProductTypeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductTypeController {
    @Resource(name = "productTypeService")
    private HibernateProductTypeService productTypeService;

    @RequestMapping(value = "/product_types", method = RequestMethod.GET)
    public JsonHttpResponse<List<ProductType>> getProductTypes(){
        return new JsonHttpResponse<>(productTypeService.allProductTypes(), true);
    }

    @RequestMapping(value = "/product_types/{productTypeId}/products")
    public JsonHttpResponse<List<Product>> getProducts(@PathVariable("productTypeId") int productTypeId){
        return new JsonHttpResponse<>();
    }
}
