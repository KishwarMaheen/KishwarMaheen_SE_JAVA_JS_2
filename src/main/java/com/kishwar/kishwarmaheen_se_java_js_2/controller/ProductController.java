package com.kishwar.kishwarmaheen_se_java_js_2.controller;

import com.kishwar.kishwarmaheen_se_java_js_2.entity.ProductEntity;
import com.kishwar.kishwarmaheen_se_java_js_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @CrossOrigin
    public boolean createProduct(@RequestParam String username,
                                 @RequestParam String name,
                                 @RequestParam String price,
                                 @RequestParam String profitPercentage,
                                 @RequestParam String productType){
        return productService.createProduct(username,
                name,
                Double.parseDouble(price),
                Double.parseDouble(profitPercentage),
                productType);
    }

    @GetMapping
    @CrossOrigin
    public List<ProductEntity> getAllProducts(@RequestParam String username){
        return productService.getAllProducts(username);
    }

    @PutMapping
    @CrossOrigin
    public boolean updateProduct(@RequestParam String id,
                                 @RequestParam String name,
                                 @RequestParam String price,
                                 @RequestParam String profitPercentage,
                                 @RequestParam String productType){
        return productService.updateProduct(Long.parseLong(id),
                name,
                Double.parseDouble(price),
                Double.parseDouble(profitPercentage),
                productType);
    }

    @DeleteMapping
    @CrossOrigin
    public boolean deleteProduct(@RequestParam long id){
        return productService.deleteProduct(id);
    }
}
