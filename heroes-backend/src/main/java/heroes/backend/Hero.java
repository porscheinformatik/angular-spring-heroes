package heroes.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HEROES")
public class Hero {

  @Id
  @GeneratedValue(generator = "heroesSequence")
  @SequenceGenerator(name = "heroesSequence", sequenceName = "HEROES_SEQ")
  private Integer id;

  @Column(length = 100)
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
