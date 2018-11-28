package com.spring.marcom174.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.UserAccessDao;
import com.spring.marcom174.model.UserAccessModel;

@Repository
public class UserAccessDaoImpl implements UserAccessDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void create(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userAccessModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccessModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ua from UserAccessModel ua";
		
		List<UserAccessModel> userAccessModelList = new ArrayList<UserAccessModel>();
		userAccessModelList = session.createQuery(query).list();
		
		return userAccessModelList;
	}

	@Override
	public UserAccessModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ua from UserAccessModel ua where ua.id="+id+"";
		
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = (UserAccessModel) session.createQuery(query).getSingleResult();
		
		return userAccessModel;
	}

	@Override
	public void delete(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userAccessModel);
	}

	@Override
	public void update(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userAccessModel);
	}
	
}
