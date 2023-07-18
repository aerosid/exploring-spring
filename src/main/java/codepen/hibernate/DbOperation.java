package codepen.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbOperation extends AbstractOperation {

  @Autowired
  protected DbOperation(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @SuppressWarnings("unchecked")
  public String getDbVersion() {
    NativeQueryBuilder builder = (Session session) -> {
      String sql = "select version()";
      NativeQuery<String> query = (NativeQuery<String>) session.createSQLQuery(sql);
      return query;
    };
    String version = (String)super.getSingleResult(builder);
    return version;
  }
  
}