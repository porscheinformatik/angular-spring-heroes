package heroes.backend;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Heroes
 */
public interface HeroRepository extends JpaRepository<HeroEntity, Integer> {
  List<HeroEntity> findAllByOrderByName();
  Optional<HeroEntity> findByName(String name);
}
