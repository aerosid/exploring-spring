package codepen.bean;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

  @InjectMocks
  public App app;

  @Mock
  public Greeting greeting;

  @Test
  public void executeMockTest() throws Exception {
    try (
        AutoCloseable autoCloseable = 
            MockitoAnnotations.openMocks(this);
    ) {
      Mockito.when(this.greeting.greet()).thenReturn("Namaste!");
      this.app.execute();
    }
    return;
  }

  @Test
  public void executeInSpringContext() {
    try (
        AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext("codepen.bean");
    ) {
      App app = appContext.getBean("app", App.class);
      app.execute();
    }
    return;
  }

}
