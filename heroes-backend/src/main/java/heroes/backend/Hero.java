package heroes.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hero {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  Hero() {
  }

  public Hero(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
