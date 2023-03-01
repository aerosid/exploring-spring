
import com.example.SomeBean;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IgnoreMe {

  @Test
  public void getHello() throws Throwable {
    LogFactory.getLog(this.getClass().getName()).info("IgnoreMe");
    System.setProperty("name", "Java");
    AnnotationConfigApplicationContext appContext =
        new AnnotationConfigApplicationContext("com.example");
    SomeBean bean = appContext.getBean("someBean", SomeBean.class);
    System.out.println(bean.greet());
    appContext.close();
    return;
  }
}
