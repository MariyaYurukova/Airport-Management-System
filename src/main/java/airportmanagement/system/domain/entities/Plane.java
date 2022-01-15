package airportmanagement.system.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity {

    private String codeName;
    private Integer numberOfSeats;

    private List<Flight> flight;
    private String captain;
    private String coPilot;
    private Integer countStewardesses ;
    private String flightAttendantOne;
    private String flightAttendantTwo;
    private String flightAttendantThree;
    private String flightAttendantFour;
    private String flightAttendantFive;
    private String flightAttendantSix;
    private String flightAttendantSeven;

    public Plane() {
    }


    @Column(name = "number_of_seats")
    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


    @Column(name = "code_name", unique = true)
    @Size(min=5)
    @Size(max=5)
    @Pattern(regexp = "[A-Z][A-Z][A-Z][0-9][0-9]", message = "3 capital letters 2 numbers")
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    @OneToMany(
            fetch = FetchType.LAZY, mappedBy = "plane"
    )
    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }


    @Column(name = "captain")
    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }


    @Column(name = "co_pilot")
    public String getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(String coPilot) {
        this.coPilot = coPilot;
    }



    @Column(name = "count_stewardesses")
    public Integer getCountStewardesses() {
        return countStewardesses;
    }

    public void setCountStewardesses(Integer countStewardesses) {
        this.countStewardesses = countStewardesses;
    }



    @Column(name = "first")
    public String getFlightAttendantOne() {
        return flightAttendantOne;
    }

    public void setFlightAttendantOne(String flightAttendantOne) {
        this.flightAttendantOne = flightAttendantOne;
    }

    @Column(name = "second")
    public String getFlightAttendantTwo() {
        return flightAttendantTwo;
    }

    public void setFlightAttendantTwo(String flightAttendantTwo) {
        this.flightAttendantTwo = flightAttendantTwo;
    }

    @Column(name = "third")
    public String getFlightAttendantThree() {
        return flightAttendantThree;
    }

    public void setFlightAttendantThree(String flightAttendantThree) {
        this.flightAttendantThree = flightAttendantThree;
    }

    @Column(name = "fourth")
    public String getFlightAttendantFour() {
        return flightAttendantFour;
    }

    public void setFlightAttendantFour(String flightAttendantFour) {
        this.flightAttendantFour = flightAttendantFour;
    }

    @Column(name = "fifth")
    public String getFlightAttendantFive() {
        return flightAttendantFive;
    }

    public void setFlightAttendantFive(String flightAttendantFive) {
        this.flightAttendantFive = flightAttendantFive;
    }

    @Column(name = "sixth")
    public String getFlightAttendantSix() {
        return flightAttendantSix;
    }

    public void setFlightAttendantSix(String flightAttendantSix) {
        this.flightAttendantSix = flightAttendantSix;
    }

    @Column(name = "seven")
    public String getFlightAttendantSeven() {
        return flightAttendantSeven;
    }

    public void setFlightAttendantSeven(String flightAttendantSeven) {
        this.flightAttendantSeven = flightAttendantSeven;
    }
}
