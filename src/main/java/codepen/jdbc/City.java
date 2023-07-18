package codepen.jdbc;

/* 
create database sample;

create user 'java'@'%' identified by 'hello';

grant all on sample.* to 'java'@'%';

create table city (
city_id int not null auto_increment,
name char(255) not null unique,
state char(255) not null,
primary key (city_id)) engine=InnoDB;

insert into city (name, state) values
('Chennai', 'Tamil Nadu'),
('Bengaluru', 'Karnataka'),
('Shivamogga', 'Karnataka'),
('Hyderabad', 'Telangana'),
('Pune', 'Maharashtra');
*/
public class City {

  public long cityId;

  public String name;

  public String state;

  public City() {
    super();
    this.cityId = Long.MIN_VALUE;
  }

  public static City fromJson() {
    return null;
  }

  public String toJson() {
    return null;
  }

}
