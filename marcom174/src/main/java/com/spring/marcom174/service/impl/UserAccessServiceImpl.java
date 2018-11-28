package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.UserAccessDao;
import com.spring.marcom174.model.UserAccessModel;
import com.spring.marcom174.service.UserAccessService;

@Service
@Transactional
public class UserAccessServiceImpl implements UserAccessService {
	
	@Autowired
	private UserAccessDao userAccessDao;

	@Override
	public void create(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		this.userAccessDao.create(userAccessModel);
	}

	@Override
	public List<UserAccessModel> select() {
		// TODO Auto-generated method stub
		return this.userAccessDao.select();
	}

	@Override
	public UserAccessModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.userAccessDao.searchById(id);
	}

	@Override
	public void delete(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		this.userAccessDao.delete(userAccessModel);
	}

	@Override
	public void update(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		this.userAccessDao.update(userAccessModel);
	}

}
