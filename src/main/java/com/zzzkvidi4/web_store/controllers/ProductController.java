package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductController {
    @Resource(name = "productService")
    private ProductService productService;

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public JsonHttpResponse<Product> getProductById(@PathVariable("productId") int productId){
        JsonHttpResponse<Product> response = new JsonHttpResponse<>();
        Product product = productService.findProductById(productId);
        response.setData(product);
        response.setSuccessful(product != null);
        return response;
    }
}
