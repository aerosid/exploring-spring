package codepen.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Lazy
@PropertySource({"classpath:application.properties"})
public class JdbcDispenser {

  private Environment environment;

  @Autowired
  public JdbcDispenser(Environment environment) {
    super();
    this.environment = environment;
  }

  @Bean
  public DriverManagerDataSource getDriverManagerDataSource() {
    String value = null;
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    value = this.environment.getProperty("javax.sql.DataSource.driverClassName");
    dataSource.setDriverClassName(value);
    value = this.environment.getProperty("javax.sql.DataSource.url");
    dataSource.setUrl(value);
    value = this.environment.getProperty("javax.sql.DataSource.username");
    dataSource.setUsername(value);
    value = this.environment.getProperty("javax.sql.DataSource.password");
    dataSource.setPassword(value);

    return dataSource;
  }

  @Bean
  public HikariDataSource getHikariDataSource() {
    //See https://github.com/brettwooldridge/HikariCP/blob/dev/README.md#rocket-initialization
    String value = null;
    HikariConfig config = new HikariConfig();
    value = this.environment.getProperty("javax.sql.DataSource.url");
    config.setJdbcUrl(value);
    value = this.environment.getProperty("javax.sql.DataSource.username");
    config.setUsername(value);
    value = this.environment.getProperty("javax.sql.DataSource.password");
    config.setPassword(value);
    value = this.environment.getProperty("com.zaxxer.hikari.HikariDataSource.minimumIdle");
    config.addDataSourceProperty("minimumIdle", value);
    value = this.environment.getProperty("com.zaxxer.hikari.HikariDataSource.maximumPoolSize");
    config.addDataSourceProperty("maximumPoolSize", value);

    HikariDataSource dataSource = new HikariDataSource(config);
    return dataSource;
  }

  @Bean
  public JdbcTemplate getJdbcTemplate() {
    return new JdbcTemplate(this.getDriverManagerDataSource());
  }

}
