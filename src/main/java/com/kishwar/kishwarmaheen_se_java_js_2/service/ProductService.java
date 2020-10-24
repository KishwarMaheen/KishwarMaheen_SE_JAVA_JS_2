package com.kishwar.kishwarmaheen_se_java_js_2.service;

import com.kishwar.kishwarmaheen_se_java_js_2.entity.ProductEntity;
import com.kishwar.kishwarmaheen_se_java_js_2.entity.UserEntity;
import com.kishwar.kishwarmaheen_se_java_js_2.repository.ProductRepository;
import com.kishwar.kishwarmaheen_se_java_js_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    public boolean createProduct(String username, String name, double price, double profitPercentage, String productType){
        if(username.isEmpty() || name.isEmpty() || productType.isEmpty()) return false;
        UserEntity userEntity = userRepository.findUserEntityByUsername(username);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(name);
        productEntity.setPrice(price);
        productEntity.setProfitPercentage(profitPercentage);
        productEntity.setProductType(productType);
        productEntity.setOwner(userEntity);
        productRepository.save(productEntity);
        return true;
    }

    public List<ProductEntity> getAllProducts(String username){
        return productRepository.findAllByOwner(userRepository.findUserEntityByUsername(username));
    }

    public boolean updateProduct(long id, String name, double price, double profitPercentage, String productType){
        if(name.isEmpty() || productType.isEmpty() || !productRepository.existsById(id)) return false;
        ProductEntity productEntity = productRepository.findById(id);
        productEntity.setName(name);
        productEntity.setPrice(price);
        productEntity.setProfitPercentage(profitPercentage);
        productEntity.setProductType(productType);
        productRepository.save(productEntity);
        return true;
    }

    public boolean deleteProduct(long id){
        if(!productRepository.existsById(id)) return false;
        productRepository.delete(productRepository.findById(id));
        return true;
    }
}
