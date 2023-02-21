package com.solvd.atm.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "userModel")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "userModel")
public class User {
    @XmlAttribute
    @JsonProperty("idUser")
    private long idUser;
    @XmlElement
    @JsonProperty("firstName")
    private String firstName;
    @XmlElement
    @JsonProperty("lastName")
    private String lastName;
    @XmlElement
    @JsonProperty("passportId")
    private String passportID;

    public User() {

    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", passportID=" + passportID + '}';
    }
}
