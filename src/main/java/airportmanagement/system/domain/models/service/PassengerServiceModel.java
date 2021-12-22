package airportmanagement.system.domain.models.service;

import airportmanagement.system.domain.entities.Flight;

import java.util.List;

public class PassengerServiceModel {

    private String id;
    private String name;
    private Integer age;

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


}
