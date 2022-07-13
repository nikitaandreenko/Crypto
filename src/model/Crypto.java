package model;
//create class "Crypto"
public class Crypto {
    private int id;
    private String symbol;
    private String name;
    private double price_usd;

    public Crypto (){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", price_usd=" + price_usd +
                '}';
    }
}
