package heroes;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import heroes.backend.Hero;
import heroes.backend.HeroRepository;

@SpringBootApplication
public class HeroesApplication {
  private static final String[] HEROES = { "Mr. Nice", "Narco", "Bombasto", "Celeritas", "Magneta", "RubberMan",
      "Dynama", "Dr IQ", "Magma", "Tornado" };

  public static void main(String[] args) {
    SpringApplication.run(HeroesApplication.class, args);
  }

  @Bean
  public CommandLineRunner carInit(HeroRepository heroRepository) {
    return strings -> {
      Stream.of(HeroesApplication.HEROES)
        .filter(name -> !heroRepository.findByName(name).isPresent())
        .map(name -> new Hero(name))
        .forEach(heroRepository::save);
    };
  }
}
