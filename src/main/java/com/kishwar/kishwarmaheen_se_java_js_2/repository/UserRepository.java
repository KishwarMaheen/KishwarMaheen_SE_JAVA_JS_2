package com.kishwar.kishwarmaheen_se_java_js_2.repository;


import com.kishwar.kishwarmaheen_se_java_js_2.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntityByUsernameAndPassword(String username, String password);
    UserEntity findUserEntityByUsername(String username);
    UserEntity findByEmail(String email);
}
