package heroes.backend;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Heroes
 */
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    Iterable<Hero> findAllByOrderByName();
    Optional<Hero> findByName(String name);
}
