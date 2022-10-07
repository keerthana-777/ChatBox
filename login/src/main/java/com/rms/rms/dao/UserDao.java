package com.rms.rms.dao;

import com.rms.rms.model.User;

public interface UserDao {

	public void registerUser(User user);
	 
	 public User loginUser(User user);
	

}
