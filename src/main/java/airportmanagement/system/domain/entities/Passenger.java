package airportmanagement.system.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "passengers")
public class Passenger extends BaseEntity {


  private String name;
  private Integer age;
 // private List<Flight> flight; //booking


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





}
