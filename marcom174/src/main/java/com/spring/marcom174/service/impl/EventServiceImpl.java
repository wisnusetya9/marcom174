package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.EventDao;
import com.spring.marcom174.model.EventModel;
import com.spring.marcom174.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDao eventDao;
	
	@Override
	public List<EventModel> select() {
		// TODO Auto-generated method stub
		return this.eventDao.select();
	}

}
