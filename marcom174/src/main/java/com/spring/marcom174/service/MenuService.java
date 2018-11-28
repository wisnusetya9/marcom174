package com.spring.marcom174.service;


import java.util.List;

import com.spring.marcom174.model.MenuModel;

public interface MenuService {
	public void create(MenuModel menuModel);
	public List<MenuModel> select();
	public MenuModel searchById(Integer id);
	public void delete (MenuModel menuModel);
	public void update(MenuModel menuModel);
	
	public List<MenuModel> searchByRole(Integer idRole);
}
