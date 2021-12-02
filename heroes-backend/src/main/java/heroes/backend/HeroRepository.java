package heroes.backend;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Heroes
 */
public interface HeroRepository extends JpaRepository<HeroEntity, Integer> {
    Stream<HeroEntity> findAllByOrderByName();
    Optional<HeroEntity> findByName(String name);
}
