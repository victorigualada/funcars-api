package com.funcars.api.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Client {
    private @Id @GeneratedValue Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private List<Car> cars;

    public Client(String name, String lastName, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Client(String name, String lastName, String email, String phone, List<Car> cars) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
