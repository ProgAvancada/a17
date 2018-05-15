package br.pucpr.sample;

import br.pucpr.annotations.Column;
import br.pucpr.annotations.Header;

public class Planet {

    @Header(name="Planeta   ")
    @Column(format = "%-10s")
    private String name;

    @Header(name=" Massa")
    @Column(order=1, format="%6.2f")
    private double mass;

    @Header(name="  Raio")
    @Column(order=2, format="%6.2f")
    private double radius;


    public Planet(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }
}
