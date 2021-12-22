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
    private Travel  travel;
    private Airline airline;
    private String name;
    private Integer age;
    private Plane plane;


   // private Passenger passenger;


    public FlightServiceModel() {
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



    public void setTravel(Travel travel) {
        this.travel = travel;
    }

//    public Passenger getPassenger() {
//        return passenger;
//    }
//
//    public void setPassenger(Passenger passenger) {
//        this.passenger = passenger;
//    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
