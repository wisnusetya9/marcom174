package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.UserDao;
import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void create(UserModel userModel) {
		// TODO Auto-generated method stub
		this.userDao.create(userModel);
	}

	@Override
	public List<UserModel> select() {
		// TODO Auto-generated method stub
		return this.userDao.select();
	}

	@Override
	public UserModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.searchById(id);
	}

	@Override
	public void delete(UserModel userModel) {
		// TODO Auto-generated method stub
		this.userDao.delete(userModel);
	}

	@Override
	public void update(UserModel userModel) {
		// TODO Auto-generated method stub
		this.userDao.update(userModel);
	}

	@Override
	public UserModel searchByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return this.userDao.searchByUsernamePassword(username, password);
	}

	

	/*//TESS
	@Override
	public List<UserModel> searchNameRole(Integer idRole) {
		// TODO Auto-generated method stub
		return this.userDao.searchNameRole(idRole);
	}*/

}
