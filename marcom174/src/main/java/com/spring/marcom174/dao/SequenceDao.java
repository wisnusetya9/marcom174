package com.spring.marcom174.dao;

public interface SequenceDao {

	//for master product
	public Integer nextIdProduct();
	
	//for tansaction Souvenir Settlement
	public Integer nextIdSouvenirSettlement();
}
