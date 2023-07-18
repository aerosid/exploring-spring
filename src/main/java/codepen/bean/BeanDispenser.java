package codepen.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class BeanDispenser {

  private SomeBean someBean;

  @Autowired
  public BeanDispenser(SomeBean someBean) {
    super();
    this.someBean = someBean;
  }

  @Bean
  public SomeBean getSomeBean() {
    return this.someBean;
  }

}