package com.flybyu.web.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public User getById(int id)
    {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

	@SuppressWarnings("unchecked")
	public User getByUsername(String username)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> userList = criteria.list();
        
        if (userList.size() > 0) {
        	return userList.get(0);
        } else {
        	return null;
        }
    }
}
