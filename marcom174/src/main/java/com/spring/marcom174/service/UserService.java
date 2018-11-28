package com.spring.marcom174.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.spring.marcom174.model.UserModel;

@Service
public interface UserService {
	
	public void create(UserModel userModel);
	public List<UserModel> select();
	public UserModel searchById(Integer id);
	public void delete(UserModel userModel);
	public void update(UserModel userModel);
	
	public UserModel searchByUsernamePassword(String username, String password);
	
	/*//TESS
	public List<UserModel> searchNameRole(Integer idRole);*/
	
}
