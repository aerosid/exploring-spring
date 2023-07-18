package codepen.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class CityOperation {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public CityOperation(JdbcTemplate jdbcTemplate) {
    super();
    this.jdbcTemplate = jdbcTemplate;
  }

  public void delete(City c) {
    return;
  }

  public City findById(long cityId) {
    final String sql = "select * from city where city_id = ?";
    RowMapper<City> mapper = this.getRowMapper();
    City c = this.jdbcTemplate.queryForObject(sql, mapper, cityId);
    return c;
  }

  public List<City> findByState(String state) {
    return null;
  }

  private RowMapper<City> getRowMapper() {
    RowMapper<City> mapper = (resultSet, rowNum) -> {
      City c = new City();
      c.cityId = resultSet.getLong("city_id");
      c.name = resultSet.getString("name");
      c.state = resultSet.getString("state");
      return c;
    };
    return mapper;
  }

  private void insert(City c) {
    return;
  }
  
  public City save(City c) {
    if (c.cityId == Long.MIN_VALUE) {
      this.insert(c);
    } else {
      this.update(c);
    }
    return c;
  }
    
  private void update(City c) {
    return;
  }
}
