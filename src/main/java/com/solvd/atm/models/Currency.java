package com.solvd.atm.models;

public class Currency {
    private long idCurrency;
    private String name;
    private double course;

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

    public double toUSD(double sum) {
        return sum / course;
    }

    public double fromUSD(double sum) {
        return sum * course;
    }

    public double toNewCourse(double sum, double newCourse) {
        return (sum / course) * newCourse;
    }

    public double fromOldCourse(double sum, double oldCourse) {
        return (sum / oldCourse) * course;
    }

}
