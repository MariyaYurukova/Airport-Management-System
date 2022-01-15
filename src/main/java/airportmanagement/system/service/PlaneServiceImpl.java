package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.entities.Plane;
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


    @Override
    public PlaneServiceModel addPlane(PlaneServiceModel planeServiceModel) {
       Plane plane= this.modelMapper.map(planeServiceModel, Plane.class);
        return this.modelMapper.map(this.planeRepository.saveAndFlush(plane), PlaneServiceModel.class);

    }

    @Override
    public PlaneServiceModel findPlaneById(String id){

        Plane plane = this.planeRepository.findById(id).get();
        return this.modelMapper.map ( plane,PlaneServiceModel.class);
    }


        @Override
        public int countPassenger(String id) {
            int flight = this.planeRepository.countPlaneId(id);
            return flight;

    }


}
