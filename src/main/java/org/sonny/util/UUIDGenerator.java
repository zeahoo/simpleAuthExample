package org.sonny.util;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UUIDGenerator implements IdentifierGenerator {

  public Serializable generate(SessionImplementor session, Object object)
      throws HibernateException {
    return UUIDUtil.getUUID();
  }
}
