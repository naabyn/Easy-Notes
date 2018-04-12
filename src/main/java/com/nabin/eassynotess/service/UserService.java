package com.nabin.eassynotess.service;

import com.nabin.eassynotess.Model.User;

public interface UserService {
    User findById(Long userId);
}
