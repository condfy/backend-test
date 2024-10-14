package com.teste.backend.api.v1.controller;

import com.teste.backend.api.v1.mapper.UserMapper;
import com.teste.backend.api.v1.record.UserDTO;
import com.teste.backend.entity.User;
import com.teste.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);

        return new ResponseEntity<>(userMapper.toDTO(userService.save(user)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers().stream().map(userMapper::toDTO).toList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userMapper.toDTO(userService.getUserById(id)), HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userService.getUserById(id), userDTO);

        return new ResponseEntity<>(userMapper.toDTO(userService.save(user)), HttpStatus.OK);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}