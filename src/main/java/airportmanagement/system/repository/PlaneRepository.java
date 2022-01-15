package airportmanagement.system.repository;

import airportmanagement.system.domain.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {

//    @Query(value="Select * Plane p ")
//    Plane findCount();

    @Query(value= "Select count (f.id ) from Flight f LEFT JOIN  Plane  p  on   p.id =f.plane ")
    int countPlaneId(String id);

}
