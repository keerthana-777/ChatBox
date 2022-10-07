package com.rms.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rms.rms.dao.UserDao;
import com.rms.rms.model.User;
@Service
public class UserServiceImpl implements UserService {

 @Autowired
 private UserDao userDao;
 @Override
 @Transactional
 public void registerUser(User user) {
  // TODO Auto-generated method stub
  userDao.registerUser(user);
 }

 @Override
 public User loginUser(User user) {
  // TODO Auto-generated method stub
  return userDao.loginUser(user);
 }

}
