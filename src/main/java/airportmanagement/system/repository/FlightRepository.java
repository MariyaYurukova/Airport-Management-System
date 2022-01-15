package airportmanagement.system.repository;

import airportmanagement.system.domain.entities.Flight;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static javax.persistence.criteria.JoinType.LEFT;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {


    @Query( " SELECT  count( f.plane) FROM Flight f  where f.plane = f.plane.id AND f.plane.id= :id ")
    int countPlaneId(String id);


// @Query( "select ( count( f.plane ) <= p.numberOfSeats) FROM Flight f  join Plane p where f.plane = f.plane.id AND f.plane.id= :id ")
  //  int countPlaneId(String id);

    Optional<Flight> findByTicketNumber(String ticketNumber);
}
