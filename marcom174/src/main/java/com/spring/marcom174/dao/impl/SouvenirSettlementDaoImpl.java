package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SouvenirSettlementDao;
import com.spring.marcom174.model.SouvenirSettlementModel;

@Repository
public class SouvenirSettlementDaoImpl implements SouvenirSettlementDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(SouvenirSettlementModel souvenirSettlementModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(souvenirSettlementModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirSettlementModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ss from SouvenirSettlementModel ss";
		List<SouvenirSettlementModel> souvenirSettlementModelList = new ArrayList<SouvenirSettlementModel>();
		souvenirSettlementModelList = session.createQuery(query).list();
		return souvenirSettlementModelList;
	}

	@Override
	public SouvenirSettlementModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ss from SouvenirSettlementModel ss "
					 + "where id = "+id +" ";
		SouvenirSettlementModel souvenirSettlementModel = new SouvenirSettlementModel();
		souvenirSettlementModel = (SouvenirSettlementModel) session.createQuery(query).getSingleResult();
		return souvenirSettlementModel;
	}

	@Override
	public void update(SouvenirSettlementModel souvenirSettlementModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(souvenirSettlementModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirSettlementModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ss from SouvenirSettlementModel ss "
						+ "where ss.isDelete = 0 ";
		List<SouvenirSettlementModel> souvenirSettlementModelList= new ArrayList<SouvenirSettlementModel>();
		souvenirSettlementModelList = session.createQuery(query).list();
		return souvenirSettlementModelList;
	}

	
	
}
