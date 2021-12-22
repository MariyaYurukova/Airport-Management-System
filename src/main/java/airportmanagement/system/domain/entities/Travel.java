package airportmanagement.system.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name= "travels")
public class Travel extends BaseEntity {


    private Airport fromAirport;
    private Airport toAirport;
    private BigDecimal travelTime;
    private BigDecimal price;
    private Gate gate;
    private List<Flight> flight;



    public Travel() {
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_id_from", referencedColumnName = "id")
    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_id_to", referencedColumnName = "id")
    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    @Column(name = "travel_time")
    public BigDecimal getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(BigDecimal travelTime) {
        this.travelTime = travelTime;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }




    @Enumerated(EnumType.STRING)
    @Column(name = "gate")
    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }



    @OneToMany(
            fetch = FetchType.LAZY, mappedBy = "travel"
    )
    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }


}
