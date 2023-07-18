package codepen.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbOperation {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public DbOperation(JdbcTemplate jdbcTemplate) {
    super();
    this.jdbcTemplate = jdbcTemplate;
  }

  public String getVersion() {
    final String sql = "select version()";
    String version = this.jdbcTemplate.queryForObject(sql, String.class);
    return version;
  }

}
