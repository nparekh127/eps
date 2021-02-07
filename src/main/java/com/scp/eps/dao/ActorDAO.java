package com.scp.eps.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.eps.hibernate.model.Actor;

@Repository
public class ActorDAO {

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

	/**
	 * @return
	 */
	public List<Actor> get() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Actor> list= session.createQuery("FROM sakila.actor").list();
		
		return list;
	}
	
	public Actor get(int id) {
		return null;
	}
	
	public boolean save(Actor actor) {
		return false;
	}
	
	public boolean delete(int id) {
		return false;
	}
}