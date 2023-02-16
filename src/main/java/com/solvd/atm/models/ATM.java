package com.solvd.atm.models;

import com.solvd.atm.utils.MyLogger;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class ATM {
    //use stream and filter by currencies
    private HashSet<Bill> bills;
    //private List<Integer> billInstances;
    private ArrayList<Bill> billList;      //all bills sorted
    private ArrayList<Bill> currPartition;
    private ArrayList<ArrayList<Bill>> allBillPartitions;

    private Card card;

    private static final MyLogger LOGGER = MyLogger.getInstance();

    public ATM() {
        card = null;
        bills = new HashSet<>();
        //billInstances = new ArrayList<>();
        allBillPartitions = new ArrayList<>();
        billList = new ArrayList<>();
        currPartition = new ArrayList<>();
        //fill ATM with bills
        Currency BYN = new Currency("BYN", 2.56);
        //Bill byn5 = new Bill(5, 20, BYN);
        Bill byn10 = new Bill(10, 10, BYN);
        Bill byn50 = new Bill(50, 5, BYN);
        Bill byn5 = new Bill(5, 50, BYN);
        Currency USD = new Currency("USD", 1);
        Bill usd20 = new Bill(20, 5, USD);
        //bills.add(byn5);
        bills.add(byn10);
        bills.add(byn50);
        bills.add(byn5);
        bills.add(usd20);
        card = new Card(new Account(BYN));
        //fill ATM with bills
    }

    public boolean withdrawalFromATM(int sum) {
        //sorted list of all bills' instances for partitions algorithm
//        List<Integer> availableBills = bills
//                .stream()
//                .filter(b -> b.getCurrency().equals(card.getAccount().getCurrency()))
//                .map(b -> {
//                    ArrayList<Integer> billElements = new ArrayList<>();
//                    for (int i = 0; i < b.getCount(); i++)
//                        billElements.add(b.getRating());
//                    return billElements.stream();
//                })
//                .flatMap(b -> b.toList().stream())
//                .sorted()
//                .toList();
//        billInstances =  availableBills;
        //billPartitions = new ArrayList<>(billInstances);

        billList = (ArrayList<Bill>) bills.stream()
                .filter(b -> b.getCurrency().equals(card.getAccount().getCurrency()))
                .sorted(Bill.COMPARE_BY_COUNT)
                .map(b -> new Bill(b.getRating(), b.getCount()))
                .collect(Collectors.toList());

        billList.forEach(bill -> currPartition.add(new Bill(bill.getRating(), 0)));
        //List<Integer> availableBills = bills.stream().flatMap(b -> b.getCurrency())

        //  PARTITIONS ALGORITHM
        partitions(0, sum);
        //
        return true;
    }

//    private void partitions(int pos, int max, int sum) {
//        if (sum == 0) {
//            //add partition
//            StringBuilder output = new StringBuilder();
//            for (int i = 0; i < pos && i < billList.size(); i++)
//                output.append(billPartitions.get(i).toString()).append(" ");
//            LOGGER.info(output);
//            //
//            return;
//        }
//        for (int i = 0; billInstances.get(i) <= max && billInstances.get(i) <= sum; i++) {
//            if (pos < billList.size())
//                billList.set(pos, billInstances.get(i));
//            partitions(pos + 1, billInstances.get(i), sum - billInstances.get(i));
//        }
//
//    }

    private void partitions(int billInd, int sum) {
            if (sum == 0) {
                ArrayList<Bill> listToAdd = new ArrayList<>();
                currPartition.forEach(b -> listToAdd.add(new Bill(b.getRating(), b.getCount())));
                allBillPartitions.add(listToAdd);
                currPartition.get(billInd).decCount(1);
                billList.get(billInd).setCount(currPartition.get(billInd).getCount());
                partitions(billInd + 1, sum + billList.get(billInd).getRating());
                return;
            }
            if (billInd >= billList.size()) {
                return;
            }
            if (sum < 0) {
                billList.get(billInd).incCount(1);
                currPartition.get(billInd).decCount(1);
                partitions(billInd + 1, sum + billList.get(billInd).getRating());
            }
            if (billList.get(billInd).getCount() == 0) {
                partitions(billInd + 1, sum);
            }
            billList.get(billInd).decCount(1);
            currPartition.get(billInd).incCount(1);
            partitions(billInd, sum - billList.get(billInd).getRating());
    }

    private boolean partitionIsEmpty(ArrayList<Bill> partition) {
        AtomicBoolean result = new AtomicBoolean(true);
        partition.forEach(b -> {
            if (b.getCount() > 0) {
                result.set(false);
            }
        });
        return result.get();
    }
}
