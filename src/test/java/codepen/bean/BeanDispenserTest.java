package codepen.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDispenserTest {

  @Test
  public void testSingleton() throws Throwable {
    String value = "Value for propB";
    System.setProperty("com.example.SomeBean.propB", value);
    try (
        AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext("codepen.bean");
    ) {
      SomeBean objA = appContext.getBean("someBean", SomeBean.class);
      int ptrA = objA.hashCode();
      BeanDispenser beanDispenser = appContext.getBean("beanDispenser", BeanDispenser.class);
      SomeBean objB = beanDispenser.getSomeBean();
      int ptrB = objB.hashCode();
      Assertions.assertEquals(ptrA, ptrB);
    }
    return;
  }
}
