package airportmanagement.system.service;

import airportmanagement.system.domain.models.service.AirportServiceModel;
import airportmanagement.system.domain.models.service.PlaneServiceModel;
import airportmanagement.system.repository.PlaneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl  implements PlaneService{

    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;



    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PlaneServiceModel> findAllPlanes() {
        return  this.planeRepository.findAll()
                .stream()
                .map(p-> this.modelMapper.map(p, PlaneServiceModel.class))
                .collect(Collectors.toList());

    }
}
