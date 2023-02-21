package com.solvd.atm.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "checks")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "checks")
public class ChecksList {
    @XmlElement(name = "check")
    @JsonProperty("check")
    private List<Check> checkList;

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }
}
