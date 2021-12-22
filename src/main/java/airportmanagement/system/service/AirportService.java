package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.models.service.AirportServiceModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AirportService {


    AirportServiceModel addAirport(AirportServiceModel airportServiceModel);

    List<AirportServiceModel> getAllAirports();

    Page<Airport> findPaginated(int pageNo, int pageSize);
}
