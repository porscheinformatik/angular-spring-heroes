package heroes.backend;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HeroController
 */
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

  private final HeroService heroService;

  public HeroController(HeroService heroService) {
    this.heroService = heroService;
  }

  @GetMapping
  public Iterable<Hero> listHeroes() {
    return heroService.listHeroes();
  }

  @GetMapping("/{id}")
  public Hero get(@PathVariable("id") Integer id) {
    return heroService.getHero(id);
  }

  @PostMapping
  public Hero create(@RequestBody Hero hero) {
    return heroService.save(hero);
  }

  @PutMapping("/{id}")
  public Hero change(@PathVariable("id") Integer id, @RequestBody Hero hero) {
    return heroService.save(hero);
  }

  @DeleteMapping("/{id}")
  public Hero delete(@PathVariable("id") Integer id) {
    return heroService.deleteHero(id);
  }
}
