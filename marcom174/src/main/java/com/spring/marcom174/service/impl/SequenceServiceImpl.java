package com.spring.marcom174.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.SequenceDao;
import com.spring.marcom174.service.SequenceService;

@Service
@Transactional
public class SequenceServiceImpl implements SequenceService{

	@Autowired
	private SequenceDao sequenceDao;
	
	@Override
	public Integer nextIdProduct() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdProduct();
	}

	@Override
	public Integer nextIdSouvenirSettlement() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdSouvenirSettlement();
	}

	

}
