package com.spring.marcom174.service;

import java.util.List;


import com.spring.marcom174.model.RoleModel;

public interface RoleService {
	public void create(RoleModel roleModel);
	public List<RoleModel> select();
	public RoleModel searchById(Integer id);
	public void delete(RoleModel roleModel);
	public void update(RoleModel roleModel);
}
