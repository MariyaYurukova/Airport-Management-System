package airportmanagement.system.domain.models.binding;

import airportmanagement.system.domain.entities.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;


import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class AddFlightReqModel {


    private String id;
    private LocalDate departure;
    private Departure departureTime;
    private Travel travel;
    private Airline airline;
    private Plane plane;
    private Integer numberOfSeats;
    private Set<Passenger> passenger;
    private String name;
    private Integer age;

    private Integer occupied;
    private String ticketNumber;
    private Integer freePlaces;

    public AddFlightReqModel() {
    }


    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Min(1)
    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }


    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @NotNull
    public Departure getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Departure departureTime) {
        this.departureTime = departureTime;
    }


    @NotNull
    public Travel getTravel() {
        return travel;
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

    @NotNull
    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }


    @NotNull
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }


    //    @NotNull
    @Size(min = 5)
    @Size(max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Size(min = 5)
    @Size(max = 5)
    @Pattern(regexp = "[A-Z][A-Z][0-9][0-9][0-9]", message = "2 capital letters 3 numbers")
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
