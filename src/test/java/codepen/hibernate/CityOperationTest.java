package codepen.hibernate;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {
  codepen.hibernate.HibernateDispenser.class, 
  codepen.hibernate.CityOperation.class})
public class CityOperationTest {

  @Autowired
  private CityOperation cityOp;

  @Test
  public void findByState() throws Throwable {
    List<City> list = this.cityOp.findByState("Karnataka");
    String cities = "cities: ";
    for (int i = 0; i < list.size(); i++) {
      City c = list.get(i);
      cities = cities + c.name + " ";
    }
    System.out.println(cities);
  }
}
