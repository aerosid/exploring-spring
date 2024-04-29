import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import codepen.jdbc.City;

public class IgnoreMe {

  @Test
  public void classForName() throws Throwable {
    Class.forName("com.mysql.cj.jdbc.Driver");    
  }

  @Test
  public void fromJson() throws Throwable {
    String json = "{\"cityId\":0,\"name\":\"Bengaluru\",\"state\":\"Karnataka\"}";
    codepen.jdbc.City c = City.fromJson(json);
    System.out.println("id:" + c.cityId + ", name:" + c.name + ", state:" + c.state);
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

  @Test
  public void toJson() throws Throwable {
    codepen.jdbc.City c = new codepen.jdbc.City();
    c.cityId = 0L;
    c.name = "Bengaluru";
    c.state = "Karnataka";
    String json = c.toJson();
    System.out.println(json);
  }  
}
