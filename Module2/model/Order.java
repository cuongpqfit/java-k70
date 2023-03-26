package Module2.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Order {
    private int id;
    private String accountId;
    private String stockId;
    private String stockName;
    private int stockPrice;
    private Timestamp purchaseDate;

    public Order(int id, String accountId, String stockId, String stockName, int stockPrice, Timestamp purchaseDate) {
        this.id = id;
        this.accountId = accountId;
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.purchaseDate = purchaseDate;
    }

    public Order(String accountId, String stockId, String stockName, String stockPrice, String purchaseDate) {
        this.accountId = accountId;
        this.stockId = stockId;
        this.stockName = stockName;
        this.setStockPrice(stockPrice);
        this.setPurchaseDate(purchaseDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }
    public void setStockPrice(String stockPrice) {
        this.stockPrice = Integer.parseInt(stockPrice);
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            this.purchaseDate = new Timestamp(dateFormat.parse(purchaseDate).getTime());
        } catch (Exception e) {
            this.purchaseDate = null;
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", stockId='" + stockId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockPrice=" + stockPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}