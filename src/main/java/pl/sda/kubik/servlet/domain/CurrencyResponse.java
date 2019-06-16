package pl.sda.kubik.servlet.domain;

import java.util.Map;

public class CurrencyResponse {
    //    {"success":true,"timestamp":1555240745,"base":"EUR","date":"2019-04-14","rates":{"USD":1.131951,"GBP":0.865207}}
    private boolean success;
    private String timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;


    public CurrencyResponse(final boolean success, final String timestamp, final String base, final String date, final Map<String, Double> rates) {
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(final String base) {
        this.base = base;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return this.rates;
    }

    public void setRates(final Map<String, Double> rates) {
        this.rates = rates;
    }
}
