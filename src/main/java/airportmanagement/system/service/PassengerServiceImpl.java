package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.entities.Passenger;
import airportmanagement.system.domain.models.service.FlightServiceModel;
import airportmanagement.system.domain.models.service.PassengerServiceModel;
import airportmanagement.system.repository.PassengerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements  PassengerService {

    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PassengerServiceModel addPassenger(PassengerServiceModel passengerServiceModel) {
        Passenger passenger= this.modelMapper.map(passengerServiceModel, Passenger.class);
        return  this.modelMapper.map(this.passengerRepository.saveAndFlush(passenger), PassengerServiceModel.class);
    }


}
