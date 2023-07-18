package codepen.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = { 
        "codepen.web", 
        "codepen.jdbc"})
public class ApplicationTest {
  
  public static void main(String[] args) {
    SpringApplication.run(ApplicationTest.class, args);
    return;
  }

}