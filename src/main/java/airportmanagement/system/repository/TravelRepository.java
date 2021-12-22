package airportmanagement.system.repository;

import airportmanagement.system.domain.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository  extends JpaRepository<Travel, String> {
}
