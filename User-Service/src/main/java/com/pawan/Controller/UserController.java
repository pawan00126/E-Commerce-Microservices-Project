package com.pawan.Controller;

import com.pawan.DTO_Mapper.UserDTO;
import com.pawan.DTO_Mapper.UserMapper;
import com.pawan.Entity.User;
import com.pawan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {

        return UserMapper.toDTO(service.createUser(user));
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }


    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        var user = service.getUserById(id);

        if(user==null){
            return getDummyUser();
        }
        return UserMapper.toDTO(user);
    }

    private UserDTO getDummyUser(){
        UserDTO dto = new UserDTO(0L, "user not found", "no email");

        return dto;
    }
}
