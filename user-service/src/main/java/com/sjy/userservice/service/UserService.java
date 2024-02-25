package com.sjy.userservice.service;

import com.sjy.userservice.dto.UserDto;
import com.sjy.userservice.entity.User;

public interface UserService{
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<User> getUserByAll();
}
