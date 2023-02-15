package com.solvd.atm.models;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ATM {
    //use stream and filter by currencies
    private HashSet<Bill> bills;
    private ArrayList<Integer> billInstances;
    private ArrayList<Integer> billPartitions;
    private Card card;

    public ATM() {
        card = null;
        bills = new HashSet<>();
        billInstances = new ArrayList<>();
        //fill ATM with bills
        Currency BYN = new Currency("BYN", 2.56);
        Bill byn5 = new Bill(5, 20, BYN);
        Bill byn10 = new Bill(10, 10, BYN);
        Bill byn50 = new Bill(50, 5, BYN);
        Currency USD = new Currency("USD", 1);
        Bill usd20 = new Bill(20, 5, USD);
        bills.add(byn5);
        bills.add(byn10);
        bills.add(byn50);
        bills.add(usd20);
        card = new Card(new Account(USD));
        //fill ATM with bills
    }

    public boolean withdrawalFromATM(int sum) {
        //sorted list of all bills' instances for partitions algorithm
        List<Integer> availableBills = bills
                .stream()
                .filter(b -> b.getCurrency().equals(card.getAccount().getCurrency()))
                .map(b -> {
                    ArrayList<Integer> billElements = new ArrayList<>();
                    for (int i = 0; i < b.getCount(); i++)
                        billElements.add(b.getRating());
                    return billElements.stream();
                })
                .flatMap(b -> b.toList().stream())
                .sorted()
                .toList();
        billInstances = (ArrayList<Integer>) availableBills;
        billPartitions = new ArrayList<>(billInstances.size());
        //List<Integer> availableBills = bills.stream().flatMap(b -> b.getCurrency())

        //  PARTITIONS ALGORITHM
        return true;
    }

    private void partitions(int pos, int max, int sum) {
        if (sum == 0) {
            //add partition
            return;
        }
        for (int i = 1; billInstances.get(i) < max && billInstances.get(i) < sum; i++) {
            billPartitions.set(i, billInstances.get(i));
        }

    }

}
