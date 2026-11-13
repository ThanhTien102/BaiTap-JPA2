package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.dto.UserDTO;
import com.java14.Jpa2.entity.UserEntity;
import com.java14.Jpa2.repository.UserRepository;
import com.java14.Jpa2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserEntity user) {
        UserEntity saved = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(saved.getId());
        userDTO.setUsername(saved.getUsername());
        userDTO.setEmail(saved.getEmail());
        return userDTO;
    }
}
