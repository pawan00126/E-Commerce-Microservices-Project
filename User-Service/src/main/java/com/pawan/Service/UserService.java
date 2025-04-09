package com.pawan.Service;

import com.pawan.Entity.User;
import com.pawan.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User createUser(User user) {
        return repository.save(user);
    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }


    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
