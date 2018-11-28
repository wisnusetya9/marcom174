package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.SouvenirSettlementDetailModel;

public interface SouvenirSettlementDetailDao {
	
	public void create(SouvenirSettlementDetailModel souvenirSettlementDetailModel);
	public List<SouvenirSettlementDetailModel> select();
	public SouvenirSettlementDetailModel searchById(Integer id);
	public void update(SouvenirSettlementDetailModel souvenirSettlementDetailModel);
	
	//Auditrail
	public List<SouvenirSettlementDetailModel> selectNotDelete();

}
