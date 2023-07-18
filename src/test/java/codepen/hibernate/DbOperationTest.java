package codepen.hibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {
  codepen.hibernate.HibernateDispenser.class, 
  codepen.hibernate.DbOperation.class})
public class DbOperationTest {

  @Autowired
  private DbOperation dbOp;

  @Test
  public void selectVersion() throws Throwable {
    String version = this.dbOp.getDbVersion();
    System.out.println("version: " + version);
    return;
  }
  
}
