package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.SouvenirSettlementDetailDao;
import com.spring.marcom174.model.SouvenirSettlementDetailModel;
import com.spring.marcom174.service.SouvenirSettlementDetailService;

@Service
@Transactional
public class SouvenirSettlementDetailServiceImpl implements SouvenirSettlementDetailService{

	@Autowired
	private SouvenirSettlementDetailDao souvenirSettlementDetailDao;
	
	@Override
	public void create(SouvenirSettlementDetailModel souvenirSettlementDetailModel) {
		// TODO Auto-generated method stub
		this.souvenirSettlementDetailDao.create(souvenirSettlementDetailModel);
	}

	@Override
	public List<SouvenirSettlementDetailModel> select() {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDetailDao.select();
	}

	@Override
	public SouvenirSettlementDetailModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDetailDao.searchById(id);
	}

	@Override
	public void update(SouvenirSettlementDetailModel souvenirSettlementDetailModel) {
		// TODO Auto-generated method stub
		this.souvenirSettlementDetailDao.update(souvenirSettlementDetailModel);
	}

	@Override
	public List<SouvenirSettlementDetailModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDetailDao.selectNotDelete();
	}

}
