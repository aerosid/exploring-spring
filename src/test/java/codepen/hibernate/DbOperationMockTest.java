package codepen.hibernate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

// See: https://www.baeldung.com/mockito-annotations
// See: https://javadoc.io/doc/org.mockito/mockito-core/latest/index.html
public class DbOperationMockTest {

  @Mock
  private DbOperation dbOp;

  @Test
  public void getVersion() throws Throwable {
    try (
        AutoCloseable autoCloseable = 
            MockitoAnnotations.openMocks(this);
    ) {
      final String version = "0.0.1-MOCK";
      Mockito
          .when(this.dbOp.getDbVersion())
          .thenReturn(version);
      System.out.println("Version: " + this.dbOp.getDbVersion());
    }
    return;
  }
  
}
