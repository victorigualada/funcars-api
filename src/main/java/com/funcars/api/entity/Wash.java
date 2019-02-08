package com.funcars.api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Wash {
    private @Id @GeneratedValue Long id;
    private double price;
    private long baseTime;
    private long washTime;
    private Car car;
    private Client client;
    private Employee whaser;

    public Wash(){}

    public Wash(double price, long baseTime, Car car, Client client, Employee whaser) {
        this.price = price;
        this.baseTime = baseTime;
        this.car = car;
        this.client = client;
        this.whaser = whaser;
    }

    public Long getId() {
        return id;
    }
}
