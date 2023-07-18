package codepen.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public abstract class AbstractOperation {

  protected SessionFactory sessionFactory;

  protected AbstractOperation(SessionFactory sessionFactory) {
    super();
    this.sessionFactory = sessionFactory;
  }

  public void delete(AbstractEntity entity) {
    return;
  }

  public Object getSingleResult(NativeQueryBuilder builder) {
    Object result = null;
    try (Session session = this.sessionFactory.openSession()) {
      NativeQuery<?> query = builder.createQuery(session);
      result = (Object)query.getSingleResult();
    }
    return result;
  }

  private AbstractEntity insert(AbstractEntity entity) {
    return null;
  }

  public List<?> list(CriteriaBuilder builder) {
    List<?> list = null;
    try (Session session = this.sessionFactory.openSession();) {
      Criteria criteria = builder.createCriteria(session);
      list = criteria.list();
    }
    return list;
  }

  public AbstractEntity save(AbstractEntity entity) {
    if (entity.isUpdate()) {
      entity = this.update(entity);
    } else {
      entity = this.insert(entity);
    }
    return null;
  }

  public AbstractEntity uniqueResult(CriteriaBuilder builder) {
    return null;
  }

  private AbstractEntity update(AbstractEntity entity) {
    return null;
  }

}