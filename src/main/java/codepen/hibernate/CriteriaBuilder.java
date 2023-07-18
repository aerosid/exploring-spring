package codepen.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;

public interface CriteriaBuilder {
  public Criteria createCriteria(Session session);
}