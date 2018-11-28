package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SouvenirSettlementDetailDao;
import com.spring.marcom174.model.SouvenirSettlementDetailModel;


@Repository
public class SouvenirSettlementDetailDaoImpl implements SouvenirSettlementDetailDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(SouvenirSettlementDetailModel souvenirSettlementDetailModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(souvenirSettlementDetailModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirSettlementDetailModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select ssd from SouvenirSettlementDetailModel ssd";
		List<SouvenirSettlementDetailModel> settlementDetailModelList = new ArrayList<SouvenirSettlementDetailModel>();
		settlementDetailModelList = session.createQuery(query).list();
		return settlementDetailModelList;
	}

	@Override
	public SouvenirSettlementDetailModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query ="select ssd from SouvenirSettlementDetailModel ssd "
					+ "where id = "+id+" ";
		SouvenirSettlementDetailModel souvenirSettlementDetailModel = new SouvenirSettlementDetailModel();
		souvenirSettlementDetailModel = (SouvenirSettlementDetailModel) session.createQuery(query).getSingleResult();
		return souvenirSettlementDetailModel;
	}

	@Override
	public void update(SouvenirSettlementDetailModel souvenirSettlementDetailModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(souvenirSettlementDetailModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirSettlementDetailModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query ="select ssd from SouvenirSettlementDetailModel ssd "
					+ "where ssd.isDelete =0 ";
		List<SouvenirSettlementDetailModel> settlementDetailModelList = new ArrayList<SouvenirSettlementDetailModel>();
		settlementDetailModelList = session.createQuery(query).list();
		return settlementDetailModelList;
	}

}
