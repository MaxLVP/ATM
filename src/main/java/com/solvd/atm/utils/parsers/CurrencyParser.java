package com.solvd.atm.utils.parsers;

import com.solvd.atm.models.Currency;
import com.solvd.atm.services.CurrencyService;
import com.solvd.atm.utils.MyLogger;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class CurrencyParser {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final String URL_TO_PARSE = "https://www.cbr-xml-daily.ru/daily_json.js";
    private static final String NAME_TO_PARSE = "Valute";
    private static final String VALUE_TO_PARSE = "Value";
    private static final String RUB_CURRENCY_NAME = "RUB";
    private static final Double RUB_CURRENCY_VALUE = 1.0;

    public static void updateCurrency() {
        RestAssured.baseURI = URL_TO_PARSE;
        Response response = RestAssured.given().request(Method.GET);
        JsonPath jsonPath = response.jsonPath();
        List<Currency> currencies = CurrencyService.getListOfCurrency();
        for (Currency currency: currencies) {
            if (currency.getName().equals(RUB_CURRENCY_NAME)) {
                currency.setCourse(RUB_CURRENCY_VALUE);
            }
            currency.setCourse(jsonPath.getDouble(String.format("%s.%S.%S", NAME_TO_PARSE, currency.getName(), VALUE_TO_PARSE)));
            boolean flag = CurrencyService.updateCurrency(currency);
            if (flag) {
                LOGGER.info("Currency " + currency.getName() + " was update ");
            } else {
                LOGGER.info("Failed to update currency " + currency.getName());
            }
        }
    }

}
