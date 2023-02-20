package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.MyLogger;

import java.util.*;

public class WithdrawMenu {
    private static final int TOTAL_COMBINATIONS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static void withdrawMoneyFromAccount(Account account, ATM atm) {
        //TODO: add static method for int input. Check if int and if in range, repeat if not
        LOGGER.info("Enter the sum to withdraw");
        int sum = SCANNER.nextInt();
        ArrayList<ArrayList<Bill>> withdrawalChoices = withdrawMoney(account, atm, sum);
        if (withdrawalChoices.isEmpty()) {
            LOGGER.info("Can't withdraw this sum");
            return;
        }
        LOGGER.info("Choose withdrawn combination");
        //printing all choices
        int i = 0;
        for (ArrayList<Bill> c:
             withdrawalChoices) {
            LOGGER.info("Choice " + i++);
            c.forEach(b -> LOGGER.info(b.getCount() +
                    " bill" + ((b.getCount() == 1) ? "" : "s") +
                    " valued " + b.getRating() + " " + b.getCurrency()));
        }
        int choice = SCANNER.nextInt();
        withdrawalChoices.get(choice - 1).forEach(b -> {
            //printing info
            LOGGER.info("Given " + b.getCount() +
            " bill" + ((b.getCount() == 1) ? "" : "s") +
            " valued " + b.getRating() + " " + b.getCurrency());
            //withdrawing from atm
            atm.getBills().stream()
                    .filter(atmBill ->
                    atmBill.getCurrency().equals(b.getCurrency()) &&
                    atmBill.getRating() == b.getRating())
                    .findFirst()
                    .get().decCount(b.getCount());
        });

        account.setTotalSum(account.getTotalSum() - sum);
        boolean flag = AccountService.updateAmountOnAccount(account);
        if (flag) {
            LOGGER.info("Money were successfully withdraw from account");
        }
        else {
            LOGGER.info("Money were not withdraw, try again");
        }
    }

    private static ArrayList<ArrayList<Bill>> withdrawMoney(Account account, ATM atm, int sum) {
        List<Bill> usedBills = new ArrayList<>(atm.getBills().stream()
                .filter(b ->
                        (b.getCurrency())
                                .equals(account.getCurrency()))
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
                result.add(new Bill(billValues.get(i), num, currency));
            }
        }
        if (sum == 0) {
            return result;
        }
        return null;
    }
}
