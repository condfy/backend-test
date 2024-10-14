package com.teste.backend.api.v1.mapper;

import com.teste.backend.api.v1.record.UserDTO;
import com.teste.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge());
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.id());
        user.setName(userDTO.name());
        user.setAge(userDTO.age());

        return user;
    }

    public User toEntity(User user, UserDTO userDTO) {
        user.setEmail(userDTO.email());
        user.setAge(userDTO.age());

        return user;
    }

}
