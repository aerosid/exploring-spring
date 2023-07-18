package codepen.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

  @Autowired
  private Greeting greeting;

  public App() {
    super();
  }

  @PreDestroy
  public void destroy() {
    return;
  }

  public void execute() {
    System.out.println(this.greeting.greet());
  }

  @PostConstruct
  public void init() {
    return;
  }

}
