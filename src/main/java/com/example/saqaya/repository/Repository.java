package com.example.saqaya.repository;

import com.example.saqaya.model.User;
import com.example.saqaya.model.UserDetails;

import java.util.List;

public interface Repository {
    
   void saveUser(User user);

    User findByEmailAddress(String email);

    User getUserById(String id);

    void saveUserDetails(UserDetails userDetails);

    List<UserDetails> getUserDetailsById(String id) throws Exception;
}
