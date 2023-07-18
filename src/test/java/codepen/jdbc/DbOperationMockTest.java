package codepen.jdbc;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

// See: https://www.baeldung.com/mockito-annotations
// See: https://javadoc.io/doc/org.mockito/mockito-core/latest/index.html
public class DbOperationMockTest {

  @InjectMocks
  private DbOperation dbOperation;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Test
  public void getVersion() throws Throwable {
    try (
        AutoCloseable autoCloseable = 
            MockitoAnnotations.openMocks(this);
    ) {
      final String sql = "select version()";
      final String version = "0.0.0-MOCK";
      Mockito
          .when(this.jdbcTemplate.queryForObject(sql, String.class))
          .thenReturn(version);
      System.out.println("Version: " + this.dbOperation.getVersion());
    }
    return;
  }
  
}
