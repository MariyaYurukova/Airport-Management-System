package airportmanagement.system.domain.models.binding;

import airportmanagement.system.domain.entities.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class AddFlightReqModel {


    private String id;
    private LocalDate departure;
    private Departure departureTime;
    private String name;
    private Integer age;
   private Travel  travel;
   private Airline airline;
    private Plane plane;


  //  private Passenger passenger;


    public AddFlightReqModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd")
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


//    public Passenger getPassenger() {
//        return passenger;
//    }
//
//    public void setPassenger(Passenger passenger) {
//        this.passenger = passenger;
//    }

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
