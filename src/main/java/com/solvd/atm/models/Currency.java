package com.solvd.atm.models;

public class Currency {
    private long idCurrency;
    private String name;
    private double course;

    public Currency() {
    }

    public long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public Currency(String name, double course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "idCurrency=" + idCurrency +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
