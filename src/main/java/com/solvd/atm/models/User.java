package com.solvd.atm.models;

public class User {
    private long idUser;
    private String firstName;
    private String lastName;
    private String passportID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public User(String firstName, String lastName, String passportID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportID = passportID;
    }

    public User() {
    }
}
