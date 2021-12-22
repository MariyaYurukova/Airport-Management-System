package airportmanagement.system.repository;

import airportmanagement.system.domain.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {
}
