package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.entities.Gate;

import java.math.BigDecimal;

public class TravelServiceModel {



    private String id;
   private Airport fromAirport;
    private Airport toAirport;
    private BigDecimal travelTime;
    private BigDecimal price;
    private Gate gate;
  //  private Flight flight;


    public TravelServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public BigDecimal getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(BigDecimal travelTime) {
        this.travelTime = travelTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

//    public Flight getFlight() {
//        return flight;
//    }
//
//    public void setFlight(Flight flight) {
//        this.flight = flight;
//    }
}
