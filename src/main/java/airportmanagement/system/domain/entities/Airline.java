package airportmanagement.system.domain.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "airlines")
public class Airline extends BaseEntity{

    private String name;
    private List<Flight> flightList;


    public Airline() {
    }



    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @OneToMany(
            fetch = FetchType.LAZY, mappedBy = "airline"
    )
    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }





}
