package airportmanagement.system.service;

import airportmanagement.system.domain.models.service.PlaneServiceModel;

import java.util.List;

public interface PlaneService {

    List<PlaneServiceModel> findAllPlanes();

    PlaneServiceModel addPlane(PlaneServiceModel planeServiceModel);

    PlaneServiceModel findPlaneById(String id);

    int countPassenger(String id);

}
