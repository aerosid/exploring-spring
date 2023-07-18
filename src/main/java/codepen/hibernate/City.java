package codepen.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  public long cityId;

  @Column(name = "name")
  public String name;

  @Column(name = "state")
  public String state;

  public City() {
    super();
    this.cityId = Long.MIN_VALUE;
  }

  public static City fromJson() {
    return null;
  }

  @Override
  protected boolean isUpdate() {
    boolean isUpdate = (this.cityId == Long.MIN_VALUE) ? false : true;
    return isUpdate;
  }

  public String toJson() {
    return null;
  }

}