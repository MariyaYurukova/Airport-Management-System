package airportmanagement.system.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "airports")
public class Airport extends BaseEntity{


      private String name;
      private List<Travel> fromPLace;
      private List<Travel> toPlace;



      public Airport() {
      }

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY, mappedBy = "fromAirport"
  )
    public List<Travel> getFromPLace() {
        return fromPLace;
    }

    public void setFromPLace(List<Travel> fromPLace) {
        this.fromPLace = fromPLace;
    }


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "toAirport"
    )
    public List<Travel> getToPlace() {
        return toPlace;
    }

    public void setToPlace(List<Travel> toPlace) {
        this.toPlace = toPlace;
    }

    @Column(name = "name", unique = true)
      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }





}
