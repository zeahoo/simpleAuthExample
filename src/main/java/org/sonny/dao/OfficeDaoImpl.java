package org.sonny.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sonny.model.Office;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeDaoImpl implements OfficeDao {

  private final SessionFactory sessionFactory;

  public OfficeDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public Office findOfficeById(String id) {
    return (Office) getSession().get(Office.class, id);
  }

  public List findOfficeByParentId(String parentId) {
    Criteria criteria = getSession().createCriteria(Office.class);
    criteria.add(Restrictions.or(Restrictions.eq("id", parentId),
        Restrictions.like("parentIds", "%" + parentId + "%")));
    return criteria.list();
  }
}
