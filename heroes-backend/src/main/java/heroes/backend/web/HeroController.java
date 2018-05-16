package heroes.backend.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heroes.backend.Hero;
import heroes.backend.HeroRepository;

/**
 * HeroController
 */
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

  private final HeroRepository heroRepository;

  public HeroController(HeroRepository heroRepository) {
    super();
    this.heroRepository = heroRepository;
  }

  @GetMapping
  public Iterable<Hero> listHeroes() {
    return heroRepository.findAllByOrderByName();
  }

  @GetMapping("/{id}")
  public Hero get(@PathVariable("id") Integer id) {
    return heroRepository.findById(id).orElse(null);
  }

  @PostMapping
  public Hero create(@RequestBody Hero hero) {
    return heroRepository.save(hero);
  }

  @PutMapping("/{id}")
  public Hero change(@PathVariable("id") Integer id, @RequestBody Hero hero) {
    return heroRepository.save(hero);
  }

  @DeleteMapping("/{id}")
  public Hero delete(@PathVariable("id") Integer id) {
    Hero hero = heroRepository.findById(id).orElse(null);
    if (hero != null) {
      heroRepository.delete(hero);
    }
    return hero;
  }

}
