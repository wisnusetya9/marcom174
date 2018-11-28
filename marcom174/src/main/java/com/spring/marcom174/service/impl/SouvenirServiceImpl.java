package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.SouvenirDao;
import com.spring.marcom174.model.SouvenirModel;
import com.spring.marcom174.service.SouvenirService;

@Service
@Transactional
public class SouvenirServiceImpl implements SouvenirService{

	@Autowired
	private SouvenirDao souvenirDao;
	
	@Override
	public List<SouvenirModel> select() {
		// TODO Auto-generated method stub
		return this.souvenirDao.select();
	}

}
