package codepen.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SomeBeanTest {

  @Test
  public void testProps() throws Throwable {
    String value = "Value for propB";
    System.setProperty("com.example.SomeBean.propB", value);
    try (
        AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext("codepen.bean");
    ) {
      SomeBean bean = appContext.getBean("someBean", SomeBean.class);
      String propA = bean.getPropA();
      Assertions.assertEquals("/home/ubuntu", propA);
      String propB = bean.getPropB();
      Assertions.assertEquals(value, propB);
      String propC = bean.getPropC();
      Assertions.assertEquals("Hello, Java!", propC);
      String propD = bean.getPropD();
      Assertions.assertEquals("propD", propD);
    }
  }

}
