package com.rms.rms.service;

import com.rms.rms.model.User;

public interface UserService {

 public void registerUser(User user);
 
 public User loginUser(User user);
}