package com.example;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Greeting {

  public Greeting() {
    super();
  }

  public String greet() {
    return "Hello World!";
  }

}
