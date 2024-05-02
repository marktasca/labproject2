package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;
import java.sql.Time;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        ObjectMapper m = new ObjectMapper();
        JsonNode main = m.readTree(json);
        JsonNode results = main.get("results").get(0);

        String Symbol = main.get("ticker").asText();
        double OpenPrice = results.get("o").asDouble();
        double ClosePrice = results.get("c").asDouble();
        double HighestPrice = results.get("h").asDouble();
        double LowestPrice = results.get("l").asDouble();
        double TradingVolume = results.get("v").asDouble();
        int NumberOfTransactions = results.get("n").asInt();
        long Timestamp = results.get("t").asLong();

        return new StockQuote(Symbol,ClosePrice,HighestPrice,LowestPrice,NumberOfTransactions,OpenPrice,Timestamp,TradingVolume);

    }
}
