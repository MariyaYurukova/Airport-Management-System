package airportmanagement.system.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import java.util.Set;





@Entity
@Table(name = "flights")
public class Flight extends BaseEntity {


    private LocalDate departure;
    private Departure departureTime;
    private Travel travel;
    private Airline airline;
  //  private Set<Passenger> passenger;

    private Integer occupied;
   private Integer  freePlaces;
    private Plane plane;

    String ticketNumber;
    // count3 size  @ for this one


    public Flight() {
    }

    @Column(name = "free_places")
    @Min(1)
    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }



    @Column(name = "place_number")
    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id", referencedColumnName = "id")
    @JsonIgnore
    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Column(name = "departure")
    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "departurtureTime")
    public Departure getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Departure departureTime) {
        this.departureTime = departureTime;
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    @JsonIgnore
    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    @JsonIgnore
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }


//  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//  @JoinColumn(name = "passenger_id", referencedColumnName = "id")
//  @JsonIgnore
//  @ManyToMany(fetch = FetchType.LAZY,mappedBy = "passenger")


//  @OneToMany(
//          mappedBy = "flight"
//  )


//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//
//            , targetEntity = Passenger.class)
//    @JoinTable(
//            name = "flights_passengers",
//            joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "passenger_id", referencedColumnName = "id")}
//    )
//    public Set<Passenger> getPassenger() {
//        return passenger;
//    }
//
//    public void setPassenger(Set<Passenger> passenger) {
//        this.passenger = passenger;
//    }


    @Column(name = "ticket_number", unique = true)
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}


