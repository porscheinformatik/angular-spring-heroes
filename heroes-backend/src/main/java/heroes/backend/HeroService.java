package heroes.backend;

import java.util.stream.Stream;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class HeroService implements InitializingBean {

  public static final String[] HEROES = {
    "Mr. Nice",
    "Narco",
    "Bombasto",
    "Celeritas",
    "Magneta",
    "RubberMan",
    "Dynama",
    "Dr IQ",
    "Magma",
    "Tornado",
  };

  private final HeroRepository heroRepository;

  public HeroService(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }

  @Override
  @Transactional
  public void afterPropertiesSet() {
    Stream
      .of(HEROES)
      .filter(name -> heroRepository.findByName(name).isEmpty())
      .map(HeroEntity::new)
      .forEach(heroRepository::save);
  }

  public Iterable<Hero> listHeroes() {
    return heroRepository.findAllByOrderByName().map(HeroEntity::toHero).toList();
  }

  public Hero getHero(Integer id) {
    return heroRepository.findById(id).map(HeroEntity::toHero).orElse(null);
  }

  @Transactional
  public Hero save(Hero hero) {
    if (hero.id() == null) {
      return heroRepository.save(new HeroEntity(hero.name())).toHero();
    } else {
      HeroEntity dbHero = heroRepository.getReferenceById(hero.id());
      dbHero.setName(hero.name());
      return dbHero.toHero();
    }
  }

  @Transactional
  public Hero deleteHero(Integer id) {
    HeroEntity dbHero = heroRepository.findById(id).orElse(null);
    if (dbHero == null) {
      return null;
    }
    heroRepository.delete(dbHero);
    return dbHero.toHero();
  }
}
