package com.example;

import org.junit.jupiter.api.Test;

public class GreetingTest {

  @Test
  public void testGreet() throws Throwable {
    System.out.println((new Greeting()).greet());
  }

}
