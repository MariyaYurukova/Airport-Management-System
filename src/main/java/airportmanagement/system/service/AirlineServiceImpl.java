package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Airline;
import airportmanagement.system.domain.models.service.AirlineServiceModel;
import airportmanagement.system.repository.AirlineRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService {

 private final AirlineRepository airlineRepository;
  private final ModelMapper modelMapper;

  @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository, ModelMapper modelMapper) {
     this.airlineRepository = airlineRepository;
     this.modelMapper = modelMapper;
 }

    @Override
    public AirlineServiceModel addAirline(AirlineServiceModel airlineServiceModel) {
      Airline airline= this.modelMapper.map(airlineServiceModel, Airline.class);
        return this.modelMapper.map(this.airlineRepository.saveAndFlush(airline), AirlineServiceModel.class);

    }


    @Override
    public List<AirlineServiceModel> getAllAirlines(){
        return  this.airlineRepository.findAll()
                .stream()
                .map(e -> this.modelMapper.map(e,AirlineServiceModel.class))
                .collect(Collectors.toList());

    }


    @Override
    public Page<Airline> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, 7);
        return this.airlineRepository.findAll(pageable);
    }
}
