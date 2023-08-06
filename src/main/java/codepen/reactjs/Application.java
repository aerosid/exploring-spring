package codepen.reactjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"codepen.reactjs"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    return;
  }

}
