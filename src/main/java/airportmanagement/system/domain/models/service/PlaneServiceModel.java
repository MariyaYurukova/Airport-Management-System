package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.entities.Passenger;

import java.util.List;

public class PlaneServiceModel {


    private String id;
    private String codeName;
    private Integer numberOfSeats;
    private List<Flight> flight;
    private String  captain;
    private String  coPilot;

    private Integer countStewardesses ;
    private String flightAttendantOne;
    private String flightAttendantTwo;
    private String flightAttendantThree;
    private String flightAttendantFour;
    private String flightAttendantFive;
    private String flightAttendantSix;
    private String flightAttendantSeven;



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


    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(String coPilot) {
        this.coPilot = coPilot;
    }


    public Integer getCountStewardesses() {
        return countStewardesses;
    }

    public void setCountStewardesses(Integer countStewardesses) {
        this.countStewardesses = countStewardesses;
    }

    public String getFlightAttendantOne() {
        return flightAttendantOne;
    }

    public void setFlightAttendantOne(String flightAttendantOne) {
        this.flightAttendantOne = flightAttendantOne;
    }

    public String getFlightAttendantTwo() {
        return flightAttendantTwo;
    }

    public void setFlightAttendantTwo(String flightAttendantTwo) {
        this.flightAttendantTwo = flightAttendantTwo;
    }

    public String getFlightAttendantThree() {
        return flightAttendantThree;
    }

    public void setFlightAttendantThree(String flightAttendantThree) {
        this.flightAttendantThree = flightAttendantThree;
    }

    public String getFlightAttendantFour() {
        return flightAttendantFour;
    }

    public void setFlightAttendantFour(String flightAttendantFour) {
        this.flightAttendantFour = flightAttendantFour;
    }

    public String getFlightAttendantFive() {
        return flightAttendantFive;
    }

    public void setFlightAttendantFive(String flightAttendantFive) {
        this.flightAttendantFive = flightAttendantFive;
    }

    public String getFlightAttendantSix() {
        return flightAttendantSix;
    }

    public void setFlightAttendantSix(String flightAttendantSix) {
        this.flightAttendantSix = flightAttendantSix;
    }

    public String getFlightAttendantSeven() {
        return flightAttendantSeven;
    }

    public void setFlightAttendantSeven(String flightAttendantSeven) {
        this.flightAttendantSeven = flightAttendantSeven;
    }
}
