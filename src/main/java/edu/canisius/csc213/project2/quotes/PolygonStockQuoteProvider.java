package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public String getEndpointUrl(String symbolName, String date, String apiKey){
        /* 
        * The method is expected to return a well formed URL to contact a quote provider.
        * For example, if you provided:
        * 
        * symbol - AAPL
        * date   - 2023-01-09
        * key    - yourKey
        * 
        * It would reply with: 
        * https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2023-01-09/2023-01-09?apiKey=yourKey
        */
        Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher m = p.matcher(date);
        if(!m.find()){
            throw new IllegalArgumentException();
        }
        return "https://api.polygon.io/v2/aggs/ticker/" + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;
    }
   
    public static String sendGetRequest(String endpointUrl) throws IOException {
        URL url = new URL(endpointUrl);

        // Open an HTTP connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method (GET by default)
        connection.setRequestMethod("GET");

        // Create a BufferedReader to read the content
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // String to hold the content
        StringBuilder content = new StringBuilder();
        String line;

        // Read each line from the input stream and append it to the content
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        // Close the reader
        reader.close();

    

        // Disconnect the connection
        connection.disconnect();
        
        return(content.toString());
        
    }


}
