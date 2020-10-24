package com.kishwar.kishwarmaheen_se_java_js_2.repository;

import com.kishwar.kishwarmaheen_se_java_js_2.entity.ProductEntity;
import com.kishwar.kishwarmaheen_se_java_js_2.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByOwner(UserEntity userEntity);
    ProductEntity findById(long id);
}
