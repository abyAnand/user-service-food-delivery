package com.delivery.userservice.service;

import com.delivery.userservice.dto.UserDTO;
import com.delivery.userservice.entity.User;
import com.delivery.userservice.mapper.UserMapper;
import com.delivery.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer userId) {
        Optional<User> fetchedUser = userRepository.findByUserId(userId);
        return fetchedUser
                .map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
