package com.java14.Jpa2.services;

import com.java14.Jpa2.dto.UserDTO;
import com.java14.Jpa2.entity.UserEntity;

public interface UserServices {
    UserDTO addUser(UserEntity user);
}
