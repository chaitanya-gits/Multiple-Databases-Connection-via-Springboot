package com.demo.service;

import com.demo.entity.UserDetails;
import com.demo.exception.UserNotFoundException;
import com.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails createUser(UserDetails userDetails){
        return userRepository.save(userDetails);
    }

    public List<UserDetails> getAllUsers(){
        return userRepository.findAll();
    }

    public UserDetails getById(int id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    public UserDetails updateById(int id, UserDetails userDetails) {
        UserDetails user = getById(id);
        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }


    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
