package com.scp.eps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scp.eps.dao.ActorDAO;
import com.scp.eps.hibernate.model.Actor;

@Service
public class ActorServiceImpl {
	
	@Autowired
	ActorDAO actorDao;
	
	@Transactional
	public List<Actor> getAllActors() {
		//test comments
		
		return actorDao.get();
	}

}
