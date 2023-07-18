import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class IgnoreMe {

  @Test
  public void classForName() throws Throwable {
    Class.forName("com.mysql.cj.jdbc.Driver");    
  }

  @Test
  public void testSingleton() throws Throwable {
    String value = "Value for propB";
    System.setProperty("com.example.SomeBean.propB", value);
    try (
        AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext("codepen.jdbc");
    ) {
      DriverManagerDataSource ds1 = appContext.getBean(DriverManagerDataSource.class);
      int ptrA = ds1.hashCode();
      JdbcTemplate jdbcTemplate = appContext.getBean(JdbcTemplate.class);
      DataSource ds2 = jdbcTemplate.getDataSource();
      int ptrB = ds2.hashCode();
      Assertions.assertEquals(ptrA, ptrB);
    }
    return;
  }  
}
