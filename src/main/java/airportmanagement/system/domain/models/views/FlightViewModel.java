package airportmanagement.system.domain.models.views;

import airportmanagement.system.domain.entities.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FlightViewModel {

    private String id;
    private LocalDate departure;
    private Departure departureTime;

    private Integer terminal;
    private Travel travel;
    private Airline airline;
    private Plane plane;

    private Passenger passenger;

    public FlightViewModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public Departure getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Departure departureTime) {
        this.departureTime = departureTime;
    }


    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }


    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
