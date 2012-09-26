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
public class ActivitiesDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public Activity getById(int id)
    {
        return (Activity) sessionFactory.getCurrentSession().get(Activity.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Activity> searchContacts(String name)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Activity.class);
        criteria.add(Restrictions.ilike("name", name+"%"));
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Activity> getAllActivities()
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Activity.class);
        return criteria.list();
    }
    
    public int save(Activity activity)
    {
        return (Integer) sessionFactory.getCurrentSession().save(activity);
    }
    
    public void update(Activity activity)
    {
        sessionFactory.getCurrentSession().merge(activity);
    }
    
    public void delete(int id)
    {
    	Activity c = getById(id);
        sessionFactory.getCurrentSession().delete(c);
    }

}
