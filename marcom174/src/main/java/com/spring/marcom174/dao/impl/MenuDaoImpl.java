package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.MenuDao;
import com.spring.marcom174.model.MenuModel;


@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(MenuModel menuModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(menuModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select mm from MenuModel mm";
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = session.createQuery(query).list();
		
		return menuModelList;
	}

	@Override
	public MenuModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select mm from MenuModel mm where mm.id="+id+"";
		
		MenuModel menuModel = new MenuModel();
		menuModel = (MenuModel) session.createQuery(query).getSingleResult();
		
		return menuModel;
	}

	@Override
	public void delete(MenuModel menuModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(menuModel);
		
	}

	@Override
	public void update(MenuModel menuModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(menuModel);
	}

	@SuppressWarnings({ "unchecked",  "rawtypes" })
	@Override
	public List<MenuModel> searchByRole(Integer idRole) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "SELECT "
				       + " M.ID ID, "
					   + " M.NAMA NAMA, "
					   + " M.KODE KODE, "
					   + " M.CONTROLLER CONTROLLER "
					   + " FROM M_MENU M "
					   + " JOIN M_USERACCESS UA "
					   + " ON UA.ID_MENU = M.ID "
					   + " WHERE UA.ID_ROLE ="+idRole+" "
					   + " ORDER BY M.NAMA ASC ";
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.addEntity(MenuModel.class);
		
		menuModelList = sqlQuery.list();
		
		return menuModelList;
	}
	
	
}

