package codepen.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityOperation extends AbstractOperation {

  @Autowired
  protected CityOperation(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public void delete(City c) {
    return;
  }

  public City findById(long cityId) {
    return null;
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  public List<City> findByState(String state) {
    CriteriaBuilder builder = (Session session) -> {
      Criteria criteria = session.createCriteria(City.class);
      criteria.add(Restrictions.eq("state", state));
      return criteria;
    };
    List<City> list = (List<City>)this.list(builder);
    return list;
  }

  public City save(City c) {
    return this.save(c);
  }

}