package heroes.backend;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class HeroService implements InitializingBean {

  private static final String[] HEROES = {"Mr. Nice", "Narco", "Bombasto", "Celeritas", "Magneta", "RubberMan",
    "Dynama", "Dr IQ", "Magma", "Tornado"};

  private final HeroRepository heroRepository;

  public HeroService(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }

  @Override
  @Transactional
  public void afterPropertiesSet() {
    Stream.of(HEROES)
      .filter(name -> heroRepository.findByName(name).isEmpty())
      .map(Hero::new)
      .forEach(heroRepository::save);
  }

  public Iterable<Hero> listHeroes() {
    return heroRepository.findAllByOrderByName();
  }

  public Hero getHero(Integer id) {
    return heroRepository.findById(id).orElse(null);
  }

  @Transactional
  public Hero save(Hero hero) {
    return heroRepository.save(hero);
  }

  @Transactional
  public Hero deleteHero(Integer id) {
    Hero hero = heroRepository.findById(id).orElse(null);
    if (hero != null) {
      heroRepository.delete(hero);
    }
    return hero;
  }
}
