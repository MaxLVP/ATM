package com.solvd.atm;

import com.solvd.atm.dao.mysql.AccountDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Check;
import com.solvd.atm.models.User;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.collections.AllChecksCollection;
import com.solvd.atm.utils.parsers.XmlParser;
import com.solvd.atm.utils.threads.AccountPool;
import org.apache.ibatis.annotations.Param;

import javax.xml.bind.JAXBException;

public class Main {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    public static void main(String[] args) throws JAXBException {
//        AccountPool.addAccountToPool(AccountService.getAllAccounts());
//        boolean exit = false;
//        while (!exit) {
//            exit = mainMenu(false);
//        }
//        Currency currency = new Currency("GBP", 0.83);
        //AccountDAO accountDAO = new AccountDAO();
//        AccountInfoMenu accountInfoMenu = new AccountInfoMenu();
        //Account account = accountDAO.getEntityById(123);
//        account.setCurrency("GBP");
//        AccountInfoMenu.getMoneyInfo(account);
//        BillsMenu.payBills(account);
//        AllChecksCollection.getAllChecks().forEach(LOGGER::info);
        //UserDAO userDAO = new UserDAO();
        //userDAO.getEntityById(1);
//        AccountPool.addAccountToPool(AccountService.getAllAccounts());
//        boolean exit = false;
//        while (!exit) {
//            exit = mainMenu(false);
//        }
        User u = new User("Artem", "Khivyk", "1234");
        Account a = new Account();
        Check check = new Check
                (u, a, "FINES PAYMENT", 100);
        Check check2 = new Check
                (u, a, "FINES PAYMENT", 100);
        Check check3 = new Check
                (u, a, "FINES PAYMENT", 100);
//        Check check2 = new Check
//                (account.getOwner(), account, "FINES PAYMENT", 100);
//        Check check3 = new Check
//                (account.getOwner(), account, "FINES PAYMENT", 100);
        AllChecksCollection.addToCheckList(check);
        AllChecksCollection.addToCheckList(check2);
        AllChecksCollection.addToCheckList(check3);
        AllChecksCollection.indexCheckList();
        AllChecksCollection.getAllChecks().forEach(LOGGER::info);
        XmlParser.writeToXml();
    }
}
