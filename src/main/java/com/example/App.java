package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

  @Autowired
  private Greeting greeting;

  public App() {
    super();
  }

  public void execute() {
    System.out.println(this.greeting.greet());
  }

}
