package airportmanagement.system.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


import java.time.LocalDate;
;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "flights")
public class Flight extends BaseEntity{


  private LocalDate departure;
  private Departure departureTime;
  private  Travel travel;
  private Airline airline;
//  private Passenger passenger;   many to one connection
  private Plane plane;

  public Flight() {
  }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id",   referencedColumnName = "id")
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


  @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST  )
  @JoinColumn(name = "airline_id",   referencedColumnName = "id")
  @JsonIgnore
  public Airline getAirline() {
    return airline;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
  }






  @ManyToOne(fetch = FetchType.LAZY )
  @JoinColumn(name = "plane_id", referencedColumnName = "id")
  @JsonIgnore
  public Plane getPlane() {
    return plane;
  }

  public void setPlane(Plane plane) {
    this.plane = plane;
  }
}


