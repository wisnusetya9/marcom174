package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.SouvenirSettlementModel;

public interface SouvenirSettlementService {

	public void create(SouvenirSettlementModel souvenirSettlementModel);
	public List<SouvenirSettlementModel> select();
	public SouvenirSettlementModel searchById(Integer id);
	
	public void update(SouvenirSettlementModel settlementModel);
	
	//AuditTrail
	public List<SouvenirSettlementModel> selectNotDelete();
}
