package codepen.hibernate;

import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Lazy
@PropertySource({
  "classpath:application.properties"})
public class HibernateDispenser {

  private Environment environment;

  @Autowired
  public HibernateDispenser(Environment environment) {
    super();
    this.environment = environment;
  }

  @Bean
  public org.hibernate.cfg.Configuration getConfiguration() {
    String value = null;
    org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
    value = this.environment.getProperty("hibernate.dialect");
    cfg.setProperty("hibernate.dialect", value);
    value = this.environment.getProperty("hibernate.connection.driver_class");
    cfg.setProperty("hibernate.connection.driver_class", value);
    value = this.environment.getProperty("hibernate.connection.url");
    cfg.setProperty("hibernate.connection.url", value);
    value = this.environment.getProperty("hibernate.connection.username");
    cfg.setProperty("hibernate.connection.username", value);
    value = this.environment.getProperty("hibernate.connection.password");
    cfg.setProperty("hibernate.connection.password", value);
    value = this.environment.getProperty("hibernate.connection.pool_size");
    cfg.setProperty("hibernate.connection.pool_size", value);
    cfg.configure("hibernate.cfg.xml");
    //See https://stackoverflow.com/questions/311408/turning-off-hibernate-logging-console-output
    java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    return cfg;
  }

  @Bean
  public SessionFactory getSessionFactory() {
    return this.getConfiguration().buildSessionFactory();
  }

}