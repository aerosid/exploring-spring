package codepen.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Lazy
@PropertySource({
  "classpath:application.properties",
  "file:///home/ubuntu/vscode/exploring-spring/src/main/resources/codepen/bean/someBean.txt"})
public class SomeBean {

  private String propA;

  @Value("${com.example.SomeBean.propB}")
  private String propB;

  @Value("${greeting}")
  private String propC;

  @Value("${com.example.SomeBean.propD}")
  private String propD;

  public SomeBean(@Value("${com.example.SomeBean.propA}")String propA) {
    super();
    this.propA = propA;
  }

  @PreDestroy
  public void destroy() {
    return;
  }

  public String getPropA() {
    return this.propA;
  }

  public String getPropB() {
    return this.propB;
  }

  public String getPropC() {
    return this.propC;
  }

  public String getPropD() {
    return this.propD;
  }

  @PostConstruct
  public void init() {
    return;
  }

}
