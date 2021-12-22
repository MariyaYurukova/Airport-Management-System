package airportmanagement.system.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "planes")
public class Plane extends BaseEntity{

    private String codeName;
  private Integer numberOfSeats;
 private List<Flight> flight;




  public Plane() {
  }

  @Column(name = "number_of_seats")
  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }


    @Column(name = "code_name")
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



}
