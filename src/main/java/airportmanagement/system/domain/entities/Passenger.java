package airportmanagement.system.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {


    private String name;
    private Integer age;
    // private Flight flight; //booking


    private String ticketNumber;

    public Passenger() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Column(name = "ticket_number")
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    // @ManyToOne( cascade = CascadeType.ALL )
// @JoinColumn(name = "flight", referencedColumnName = "id",unique=true)
// @JsonIgnore
// public Flight getFlight() {
//  return flight;
// }
//
// public void setFlight(Flight flight) {
//  this.flight = flight;
// }


// @ManyToOne(cascade = CascadeType.ALL
//        )
//public Flight getFlight() {
//  return flight;
// }
//
// public void setFlight(Flight flight) {
//  this.flight = flight;
// }


}
