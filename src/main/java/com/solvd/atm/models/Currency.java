package com.solvd.atm.models;

public class Currency {
    private String name;
    private float course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCourse() {
        return course;
    }

    public void setCourse(float course) {
        this.course = course;
    }

    public Currency(String name, float course) {
        this.name = name;
        this.course = course;
    }

    public float toUSD(float sum) {
        return sum / course;
    }

    public float fromUSD(float sum) {
        return sum * course;
    }

    public float toNewCourse(float sum, float newCourse) {
        return (sum / course) * newCourse;
    }

    public float fromOldCourse(float sum, float oldCourse) {
        return (sum / oldCourse) * course;
    }
}
