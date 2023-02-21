package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;
import com.solvd.atm.models.CurrencyInfo;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.services.BillService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.exchange.Exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class AddingMoneyMenu {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static void addMoneyToAccount(Account account, ATM atm) {
        LOGGER.info("Enter currency");
        String currency = SCANNER.next();
        boolean canContinue = false;
        CurrencyInfo currencyInfo = null;
        for (CurrencyInfo element : CurrencyInfo.values()) {
            if (element.currencyString.equals(currency)) {
                canContinue = true;
                currencyInfo = element;
            }
        }
        if (!canContinue) {
            LOGGER.info("Wrong currency");
            return;
        }
        int sum = 0;
        int billRating;
        while (true) {
            LOGGER.info("Enter bill rating or 0 to stop");
            try {
                billRating = SCANNER.nextInt();
            } catch (Exception e) {
                continue;
            }
            if (billRating == 0) {
                break;
            }
            int finalBillRating = billRating;
            if (Arrays.stream(currencyInfo.possibleValues).noneMatch(p -> p == finalBillRating)) {
                LOGGER.info("There is no such bill, try again");
                continue;
            }
            //AtomicBoolean canAddNew = new AtomicBoolean(true);
            atm.getBills().forEach(b -> {
                if (b.getCurrency().equals(currency) && b.getRating() == finalBillRating) {
                    b.incCount(1);
                    //canAddNew.set(false);
                }
            });
            //adding new bill if no bills of such values were in atm (bill never existed in the list)?
//            if (canAddNew.get()) {
//                atm.getBills().add(new Bill(billRating, 1, currency));
//            }
            sum += billRating;
        }
        //converting to account currency
        //exception might be thrown, check currency right after input
        double sumToAdd = Exchange.getExchangeAmount(currency, account.getCurrency(), sum);
        account.setTotalSum(account.getTotalSum() + sumToAdd);
        boolean flag = AccountService.updateAmountOnAccount(account);
        if (flag) {
            LOGGER.info("Money were successfully added to account");
            atm.getBills().forEach(b -> BillService.updateBill(b.getIdBill(), b.getCount()));
        } else {
            LOGGER.info("Money were not added, try again");
            atm.setBills((ArrayList<Bill>) BillService.getBillsByATMId(atm.getId()));
        }
    }


}
