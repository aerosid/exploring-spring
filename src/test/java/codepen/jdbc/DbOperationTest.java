package codepen.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {
  codepen.jdbc.JdbcDispenser.class, 
  codepen.jdbc.DbOperation.class})
public class DbOperationTest {

  @Autowired
  private DbOperation dbOperation;

  @Test
  public void getVersion() throws Throwable {
    String version = this.dbOperation.getVersion();
    System.out.println("Version: " + version);
    return;
  }
}
