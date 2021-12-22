package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Airline;
import airportmanagement.system.domain.models.service.AirlineServiceModel;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface AirlineService {

  AirlineServiceModel addAirline(AirlineServiceModel airlineServiceModel);

    List<AirlineServiceModel> getAllAirlines();

  Page<Airline> findPaginated(int pageNo, int pageSize);
}
