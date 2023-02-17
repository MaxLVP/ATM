package com.solvd.atm.utils.parsers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<Date, Date> {
    @Override
    public Date unmarshal(Date date) throws Exception {
        return new SimpleDateFormat("MM-dd-yyyy").parse(String.valueOf(date));
    }

    @Override
    public Date marshal(Date date) throws Exception {
        return date;
    }
}
