package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.RoleDao;
import com.spring.marcom174.model.RoleModel;
import com.spring.marcom174.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void create(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.create(roleModel);
	}

	@Override
	public List<RoleModel> select() {
		// TODO Auto-generated method stub
		return this.roleDao.select();
	}

	@Override
	public RoleModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.roleDao.searchById(id);
	}

	@Override
	public void delete(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.delete(roleModel);
	}

	@Override
	public void update(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.update(roleModel);
	}

}
