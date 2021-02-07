package com.scp.eps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.eps.hibernate.model.Actor;
import com.scp.eps.service.ActorServiceImpl;

@RestController
@RequestMapping({"/v1/actor"})
public class ActorController {

	@Autowired
	ActorServiceImpl actorService;
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public List<Actor> getAll() {
		List<Actor> res = actorService.getAllActors(); 
		return res;
	}
}
