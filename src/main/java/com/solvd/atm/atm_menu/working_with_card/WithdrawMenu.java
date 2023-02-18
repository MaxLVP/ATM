package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;
import com.solvd.atm.utils.MyLogger;

import java.util.*;
import java.util.stream.Collectors;

public class WithdrawMenu {
    private static final int TOTAL_COMBINATIONS = 3;
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static void withdrawMoneyFromAccount(Account account, ATM atm) {

    }

    public static ArrayList<ArrayList<Bill>> withdrawMoney(ATM atm, int sum) {
        List<Bill> usedBills = new ArrayList<>(atm.getBills().stream()
                .filter(b ->
                        (b.getCurrency())
                                .equals(atm.getCard().getAccount().getCurrency()))
                .sorted(Bill.COMPARE_BY_RATING.reversed())
                .toList());  //filter bills of account's currency
        ArrayList<ArrayList<Bill>> possibleCombinations = new ArrayList<>();
        int totalCombinations = usedBills.size();
        for (int i = 0; i < totalCombinations; i++) {
            possibleCombinations.add(withdrawOperation(usedBills, sum));
            usedBills.remove(0);
        }
        possibleCombinations.removeAll(Collections.singleton(null));
        return possibleCombinations;
    }

    private static ArrayList<Bill> withdrawOperation(List<Bill> usedBills, int sum) {

        ArrayList<Bill> result = new ArrayList<>();     //result list
        String currency = usedBills.get(0).getCurrency();       //used currency as string
        List<Integer> billValues = usedBills.stream().map(Bill::getRating).toList();        //bill ratings
        List<Integer> billCounts = new ArrayList<>(usedBills.stream().map(Bill::getCount).toList());    //total bills count
        int size = billCounts.size();

        for (int i = 0; i < size && sum > 0; i++) {
            if (billCounts.get(i) > 0 && sum >= billValues.get(i)) {
                int num = Math.min(billCounts.get(i), sum / billValues.get(i));
                billCounts.set(i, billCounts.get(i) - num);
                sum -= num * billValues.get(i);
                //
//                String ending = (num == 1) ? "" : "s";
//                LOGGER.info("Given " + num + " bill" + ending +
//                        " valued " + billValues.get(i) + " " + currency);
                //
                result.add(new Bill(billValues.get(i), num, currency));
            }
        }
        if (sum == 0) {
            return result;
        }
        return null;
        //LOGGER.info(Arrays.toString(atm.getBills().toArray()));

    }
}
