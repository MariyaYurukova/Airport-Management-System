package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.entities.Distance;
import airportmanagement.system.domain.entities.GateArriving;
import airportmanagement.system.domain.entities.GateDeparture;

import java.math.BigDecimal;

public class TravelServiceModel {



    private String id;
   private Airport fromAirport;
    private Airport toAirport;
    private BigDecimal travelTime;
    private BigDecimal price;
    private GateDeparture gate;
    private GateArriving gateArriving;
  //  private Flight flight;
  private Distance distance;


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

    public GateDeparture getGate() {
        return gate;
    }

    public void setGate(GateDeparture gate) {
        this.gate = gate;
    }

//    public Flight getFlight() {
//        return flight;
//    }
//
//    public void setFlight(Flight flight) {
//        this.flight = flight;
//    }


    public GateArriving getGateArriving() {
        return gateArriving;
    }

    public void setGateArriving(GateArriving gateArriving) {
        this.gateArriving = gateArriving;
    }


    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}
