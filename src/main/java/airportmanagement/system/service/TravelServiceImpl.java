package airportmanagement.system.service;

import airportmanagement.system.domain.entities.Travel;
import airportmanagement.system.domain.models.service.TravelServiceModel;
import airportmanagement.system.repository.TravelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public TravelServiceImpl(TravelRepository travelRepository, ModelMapper modelMapper) {
        this.travelRepository = travelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public TravelServiceModel saveTravel(TravelServiceModel travelServiceModel) {
        Travel travel = this.modelMapper.map(travelServiceModel, Travel.class);
        return this.modelMapper.map(this.travelRepository.saveAndFlush(travel), TravelServiceModel.class);
    }

    @Override
    public List<TravelServiceModel> findAll(){
        return this.travelRepository.findAll()
                .stream()
                .map(t -> this.modelMapper.map(t,TravelServiceModel.class))
                .collect(Collectors.toList());
    }


}
