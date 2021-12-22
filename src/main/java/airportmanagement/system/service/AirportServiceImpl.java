package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Airline;
import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.models.service.AirlineServiceModel;
import airportmanagement.system.domain.models.service.AirportServiceModel;
import airportmanagement.system.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl  implements AirportService{



    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository, ModelMapper modelMapper) {
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public AirportServiceModel addAirport(AirportServiceModel airportServiceModel) {
        Airport airport= this.modelMapper.map(airportServiceModel, Airport.class);
        return this.modelMapper.map(this.airportRepository.saveAndFlush(airport), AirportServiceModel.class);

    }


    @Override
    public List<AirportServiceModel> getAllAirports(){
        return  this.airportRepository.findAll()
                .stream()
                .map(a-> this.modelMapper.map(a,AirportServiceModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public Page<Airport> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, 7);
        return this.airportRepository.findAll(pageable);
    }
}
