package pl.sda.kubik.servlet.dao;


import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import pl.sda.kubik.servlet.domain.CurrencyResponse;

import java.io.IOException;
import java.util.Map;

public class CurrencyDb {


    private static CurrencyDb instance;

    private CurrencyDb() {


    }

    public static CurrencyDb getInstance() {

        if (CurrencyDb.instance == null) {
            CurrencyDb.instance = new CurrencyDb();
        }
        return CurrencyDb.instance;

    }

    public Map<String, Double> getRates() throws IOException {
        final HttpClient httpClient = HttpClients.createDefault();
        final HttpGet httpGet = new HttpGet("http://data.fixer.io/api/latest?access_key=2a42cb32b8c26be61a9925dcae482a7f&base=EUR&symbols=USD,GBP");
        final RequestConfig build = RequestConfig.DEFAULT;
        final ResponseHandler<String> handler = new BasicResponseHandler();
        httpGet.setConfig(build);
        final HttpResponse response = httpClient.execute(httpGet);
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            final CurrencyResponse currencyResponse = new Gson().fromJson(handler.handleResponse(response), CurrencyResponse.class);
            return currencyResponse.getRates();

        } else {
            throw new IOException();
        }

    }


}
