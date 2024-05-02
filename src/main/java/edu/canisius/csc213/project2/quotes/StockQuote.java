package edu.canisius.csc213.project2.quotes;



public class StockQuote{

    //Variables

    double ClosePrice;
    double HighestPrice;
    double LowestPrice;
    double TradingVolume;
    double OpenPrice;
    int NumberOfTransactions;
    long Timestamp;
    String Symbol;

    public StockQuote(String Symbol, double ClosePrice, double HighestPrice, double LowestPrice,int NumberOfTransactions, double OpenPrice, long Timestamp, double TradingVolume) {
        this.ClosePrice = ClosePrice;
        this.HighestPrice = HighestPrice;
        this.LowestPrice = LowestPrice;
        this.TradingVolume = TradingVolume;
        this.OpenPrice = OpenPrice;
        this.NumberOfTransactions = NumberOfTransactions;
        this.Timestamp = Timestamp;
        this.Symbol = Symbol;
    }

   
   public double getClosePrice(){return this.ClosePrice;}
   public double getHighestPrice(){return this.HighestPrice;}
   public double getLowestPrice(){return this.LowestPrice;}
   public double getTradingVolume(){return this.TradingVolume;}
   public double getOpenPrice(){return this.OpenPrice;}
   public int getNumberOfTransactions(){return this.NumberOfTransactions;}
   public long getTimestamp(){return this.Timestamp;}
   public String getSymbol() {return this.Symbol;}
    
   public String prettyPrint(){
    return
    "Symbol: " + Symbol + "\n" +
    "Close Price: " + ClosePrice + "\n" +
    "Highest Price: " + HighestPrice + "\n"+
    "Lowest Price: " + LowestPrice + "\n" +
    "Number of Transactions: " + NumberOfTransactions + "\n" +
    "Open Price: " + OpenPrice + "\n" +
    "Trading Volume: " + TradingVolume + "\n";

   }
}
