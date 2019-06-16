package pl.sda.kubik.servlet.domain;

import pl.sda.kubik.servlet.dao.CurrencyDb;

import java.io.IOException;

public class CurrencyUtil {


    public static double reCalc(final String locale) throws IOException {
        final CurrencyDb currencyDb = CurrencyDb.getInstance();

        if (locale.equals("us")) {
            return currencyDb.getRates().get("USD");
        } else if (locale.equals("ue")) {
            return currencyDb.getRates().get("GBP");

        } else {
            return 1;
        }
    }

}
