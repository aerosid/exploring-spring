package codepen.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {
  codepen.jdbc.JdbcDispenser.class, 
  codepen.jdbc.CityOperation.class})
public class CityOperationTest {
  
  @Autowired
  private CityOperation cityOp;

  @Test
  public void findById() throws Throwable {
    City c = this.cityOp.findById(1);
    System.out.println("name: " + c.name);
    return;
  }  
}
