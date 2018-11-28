package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.EventModel;

public interface EventDao {
	public List<EventModel> select();
}
