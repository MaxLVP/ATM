package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;
import com.solvd.atm.utils.MyLogger;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class AddingMoneyMenu {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MyLogger LOGGER = MyLogger.getInstance();
    public static void addMoneyToAccount(Account account, ATM atm) {
        LOGGER.info("Enter currency");
        String currency = SCANNER.next();
        int sum = 0;
        while (true) {
            LOGGER.info("Enter bill rating or 0 to stop");
            int billRating = SCANNER.nextInt();
            if (billRating <= 0) {
                break;
            }
            AtomicBoolean canAddNew = new AtomicBoolean(true);
            atm.getBills().forEach(b -> {
                if (b.getCurrency().equals(currency) && b.getRating() == billRating) {
                    b.incCount(1);
                    canAddNew.set(false);
                }
            });
            //adding new bill if no bills of such values were in atm (bill never existed in the list)?
            if (canAddNew.get()) {
                atm.getBills().add(new Bill(billRating, 1, currency));
            }
            sum += billRating;
        }
        //converting to account currency?
        account.incTotalSum(sum);
    }
}
