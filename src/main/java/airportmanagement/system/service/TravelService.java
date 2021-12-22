package airportmanagement.system.service;

import airportmanagement.system.domain.models.service.TravelServiceModel;

import java.util.List;

public interface TravelService {

    TravelServiceModel saveTravel(TravelServiceModel travelServiceModel);

    List<TravelServiceModel> findAll();


}
