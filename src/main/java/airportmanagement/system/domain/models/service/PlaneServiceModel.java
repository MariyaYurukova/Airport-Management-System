package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.entities.Passenger;

import java.util.List;

public class PlaneServiceModel {


    private String id;
    private String codeName;
    private Integer numberOfSeats;
    private List<Flight> flight;



    public PlaneServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }



}
