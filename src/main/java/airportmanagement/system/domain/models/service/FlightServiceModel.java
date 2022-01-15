package airportmanagement.system.domain.models.service;


import airportmanagement.system.domain.entities.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class FlightServiceModel {


    private String id;
    private LocalDate departure;
    private Departure departureTime;
    private Travel travel;
    private Airline airline;
    private Plane plane;
    private Set<Passenger> passenger;
    private Integer numberOfSeats;
    private String ticketNumber;
    private Integer  freePlaces;
    private Integer occupied;

    public FlightServiceModel() {
    }

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public Travel getTravel() {
        return travel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
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

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Set<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(Set<Passenger> passenger) {
        this.passenger = passenger;
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

    public String getTicketNumber() {

        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
