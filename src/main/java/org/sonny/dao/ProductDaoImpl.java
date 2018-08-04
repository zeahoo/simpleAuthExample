package org.sonny.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sonny.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ProductDaoImpl implements ProductDao {

  private final SessionFactory sessionFactory;

  @Autowired
  ProductDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public List getProducts(String officeId, List<String> officeIdList) {
    Criteria criteria = getSession().createCriteria(Product.class);
    if (!StringUtils.isEmpty(officeId)) {
      criteria.add(Restrictions.eq("officeId", officeId));
    }
    criteria.add(Restrictions.in("officeId", officeIdList));
    return criteria.list();
  }
}
