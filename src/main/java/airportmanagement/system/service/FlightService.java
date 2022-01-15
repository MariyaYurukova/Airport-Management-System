package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.models.service.FlightServiceModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FlightService {

    FlightServiceModel addFlight(FlightServiceModel flightServiceModel) throws Exception;

    List<FlightServiceModel> findAllFlight();

    Page<Flight> findPaginated(int pageNo, int pageSize);

    int countPassenger(String id);


  // String findTicket(String tickedNumber);
}
