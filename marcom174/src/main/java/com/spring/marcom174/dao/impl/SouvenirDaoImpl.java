package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SouvenirDao;
import com.spring.marcom174.model.SouvenirModel;

@Repository
public class SouvenirDaoImpl implements SouvenirDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select s from SouvenirModel s";
		List<SouvenirModel> souvenirModelList = new ArrayList<SouvenirModel>();
		souvenirModelList = session.createQuery(query).list();
		return souvenirModelList;
	}

}
