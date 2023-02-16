package com.solvd.atm.utils.collections;

import com.solvd.atm.models.Check;

import java.util.ArrayList;
import java.util.List;

public class AllChecksCollection {
    private static final List<Check> CHECK_LIST = new ArrayList<>();

    public static List<Check> getAllChecks() {
        return CHECK_LIST;
    }
    public static void addToCheckList(Check check) {
        CHECK_LIST.add(check);
    }

    public static void indexCheckList() {
        CHECK_LIST.forEach(a -> a.setIdCheck(CHECK_LIST.indexOf(a) + 1));
    }
}
