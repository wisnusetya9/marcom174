package com.spring.marcom174.dao.impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SequenceDao;
import com.spring.marcom174.model.SequenceModel;


@Repository
public class SequenceDaoImpl implements SequenceDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer nextIdProduct() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idProduct = 0;
		String query = "from SequenceModel where sequenceName='M_PRODUCT_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel)session.createQuery(query).getSingleResult();
			idProduct = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			idProduct = 1;
			// TODO: handle exception
		}
		return idProduct;
	}

	@Override
	public Integer nextIdSouvenirSettlement() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idSouvenirSettlement = 0;
		String query = "from SequenceModel where sequenceName = 'T_SOUVENIR_SETTLEMENT_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel)session.createQuery(query).getSingleResult();
			idSouvenirSettlement = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idSouvenirSettlement = 1;
		}
		return idSouvenirSettlement;
	}

	
}
