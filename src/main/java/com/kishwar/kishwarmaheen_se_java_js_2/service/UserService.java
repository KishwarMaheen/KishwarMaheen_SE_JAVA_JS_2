package com.kishwar.kishwarmaheen_se_java_js_2.service;

import com.kishwar.kishwarmaheen_se_java_js_2.entity.UserEntity;
import com.kishwar.kishwarmaheen_se_java_js_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int createUser(String username, String password, String email){
        if(username.isEmpty() || password.isEmpty() || email.isEmpty()) return -1;
        else if(userRepository.findUserEntityByUsername(username) != null || userRepository.findByEmail(email) != null)
            return 0;
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userRepository.save(userEntity);
        return 1;
    }

    public boolean login(String username, String password){
        UserEntity userEntity = userRepository.findUserEntityByUsernameAndPassword(username, password);
        return userEntity != null;
    }
}
