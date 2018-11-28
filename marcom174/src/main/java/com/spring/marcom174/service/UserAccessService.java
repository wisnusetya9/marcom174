package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.UserAccessModel;

public interface UserAccessService {
	public void create(UserAccessModel userAccessModel);
	public List<UserAccessModel> select();
	public UserAccessModel searchById(Integer id);
	public void delete(UserAccessModel userAccessModel);
	public void update(UserAccessModel userAccessModel);
}