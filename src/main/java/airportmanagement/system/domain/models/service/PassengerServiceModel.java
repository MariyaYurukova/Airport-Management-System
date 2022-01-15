package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Flight;

import java.util.List;
import java.util.Set;

public class PassengerServiceModel {

    private String id;
    private String name;
    private Integer age;
  //  private Flight flight;
      private String flight;

    private String ticketNumber;

    public PassengerServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
