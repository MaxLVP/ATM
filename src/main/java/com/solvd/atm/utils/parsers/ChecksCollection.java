package com.solvd.atm.utils.parsers;

import com.solvd.atm.models.Check;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "checks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChecksCollection {
    @XmlElement(name = "check")
    private List<Check> checkList;

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }
}
