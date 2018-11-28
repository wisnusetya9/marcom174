package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.MenuModel;

public interface MenuDao {
	public void create(MenuModel menuModel);
	public List<MenuModel> select();
	public MenuModel searchById(Integer id);
	public void delete (MenuModel menuModel);
	public void update(MenuModel menuModel);
	
	public List<MenuModel> searchByRole(Integer idRole);
}
