package kdc.eats.bamboo.server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BogeoRepository extends JpaRepository<BogeoEntity, Long> {
}
