package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.SouvenirSettlementModel;

public interface SouvenirSettlementDao {

	public void create(SouvenirSettlementModel souvenirSettlementModel);
	public List<SouvenirSettlementModel> select();
	public SouvenirSettlementModel searchById(Integer id);
	
	public void update(SouvenirSettlementModel settlementModel);
	
	//AuditTrail
	public List<SouvenirSettlementModel> selectNotDelete();
}
