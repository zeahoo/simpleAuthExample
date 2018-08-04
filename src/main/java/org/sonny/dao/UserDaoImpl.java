package org.sonny.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sonny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  private final SessionFactory sessionFactory;

  @Autowired
  public UserDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public List getListUser() {
    Criteria criteria = getSession().createCriteria(User.class);
    return criteria.list();
  }

  public void saveOrUpdate(User user) {
    getSession().saveOrUpdate(user);
  }

  public void deleteUser(String id) {
    User user = (User) getSession().get(User.class, id);
    getSession().delete(user);
  }

  public User findUserById(String id) {
    return (User) getSession().get(User.class, id);
  }
}
