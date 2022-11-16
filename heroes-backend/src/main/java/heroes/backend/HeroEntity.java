package heroes.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "HEROES")
public class HeroEntity {

  @Id
  @GeneratedValue(generator = "heroesSequence")
  @SequenceGenerator(name = "heroesSequence", sequenceName = "HEROES_SEQ")
  private Integer id;

  @Column(length = 100)
  private String name;

  protected HeroEntity() {
  }

  public HeroEntity(String name) {
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

  public Hero toHero() {
    return new Hero(getId(), getName());
  }
}
