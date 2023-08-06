package codepen.reactjs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Lazy
public class DummyDataSource {
  
  @Bean
  public DriverManagerDataSource getDriverManagerDataSource() {
    //Required for @EnableAutoConfiguration to work 
    //See:
    //https://stackoverflow.com/questions/75459160/
    //springboottest-loads-unwanted-beans-which-are-not-included-in-contextconfigurati
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    return dataSource;
  }
}
