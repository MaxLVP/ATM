package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WithdrawMenu {

    public static void withdrawMoneyFromAccount(Account account, ATM atm) {

    }

    public static void withdrawMoney(ATM atm, int sum) {
        //read sum to withdraw

    }

    private static void withdrawOperation(ATM atm, int sum) {
        List<Integer> billValues = atm.getBills().stream().map(Bill::getRating).toList();
        List<Integer> billCounts = atm.getBills().stream().map(Bill::getCount).toList();
        List<Integer> portions = new ArrayList<>(billValues.size());
        portions = billValues.stream().map(v -> sum / v).collect(Collectors.toList());

        //for (int i = 0; i)

    }
}
