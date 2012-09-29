package com.flybyu.web.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRelationsDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	public int save(UserRelation userRelation)
    {
        return (Integer) sessionFactory.getCurrentSession().save(userRelation);
    }
    
    public void update(UserRelation userRelation)
    {
        sessionFactory.getCurrentSession().merge(userRelation);
    }
}
