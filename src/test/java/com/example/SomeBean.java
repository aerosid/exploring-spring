package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:com/example/someBean.txt"})
public class SomeBean {

  @Value("${greeting}")
  private String greeting;

  public SomeBean() {
    super();
  }

  public String greet() {
    return this.greeting;
  }
}
