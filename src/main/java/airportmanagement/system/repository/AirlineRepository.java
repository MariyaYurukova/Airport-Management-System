package airportmanagement.system.repository;

import airportmanagement.system.domain.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository  extends JpaRepository<Airline, String> {
}
