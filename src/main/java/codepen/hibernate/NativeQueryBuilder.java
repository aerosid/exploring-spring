package codepen.hibernate;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public interface NativeQueryBuilder {
  public NativeQuery<?> createQuery(Session session);
}