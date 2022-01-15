package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.models.service.FlightServiceModel;
import airportmanagement.system.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {


    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public FlightServiceModel addFlight(FlightServiceModel flightServiceModel)  {



        Flight flight= this.modelMapper.map(flightServiceModel, Flight.class);
        return  modelMapper.map(this.flightRepository.saveAndFlush(flight), FlightServiceModel.class);
    }

    @Override
    public List<FlightServiceModel> findAllFlight(){
        return this.flightRepository.findAll()
                .stream()
                .map(f -> this.modelMapper.map(f,FlightServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public Page<Flight> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, 7);
        return this.flightRepository.findAll(pageable);
    }

    @Override
    public int countPassenger(String id) {
        int flight = this.flightRepository.countPlaneId(id);
        return flight;
    }

//    @Override
//    public String findTicket(String tickedNumber) {
//        Flight flight = this.flightRepository.findTicket(tickedNumber);
//         return    ("Ticket number exist!");
//        }
//

}
