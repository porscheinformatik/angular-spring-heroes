package heroes.backend;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Heroes
 */
public interface HeroRepository extends JpaRepository<Hero, Integer> {
}
