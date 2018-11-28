package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.SouvenirSettlementDao;
import com.spring.marcom174.model.SouvenirSettlementModel;
import com.spring.marcom174.service.SouvenirSettlementService;

@Service
@Transactional
public class SouvenirSettlementServiceImpl implements SouvenirSettlementService{

	@Autowired
	private SouvenirSettlementDao souvenirSettlementDao;
	
	@Override
	public void create(SouvenirSettlementModel souvenirSettlementModel) {
		// TODO Auto-generated method stub
		this.souvenirSettlementDao.create(souvenirSettlementModel);
	}

	@Override
	public List<SouvenirSettlementModel> select() {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDao.select();
	}

	@Override
	public SouvenirSettlementModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDao.searchById(id);
	}

	@Override
	public void update(SouvenirSettlementModel settlementModel) {
		// TODO Auto-generated method stub
		this.souvenirSettlementDao.update(settlementModel);
	}

	@Override
	public List<SouvenirSettlementModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.souvenirSettlementDao.selectNotDelete();
	}

}
