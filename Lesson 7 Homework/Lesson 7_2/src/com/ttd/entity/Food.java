package com.ttd.entity;
import java.util.Date;

public class Food {
    private String foodCode;
    private String foodName;
    private double foodPrice;
    private Date produceDate;
    private Date expiredDate;

    public Food(String foodCode, String foodName, double foodPrice, Date produceDate, Date expiredDate) {
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.produceDate = produceDate;
        this.expiredDate = expiredDate;
    }

    public Food(String foodCode){
        this.foodCode = foodCode;
    }


    public String getFoodCode()
    {
        return foodCode;
    }

    public void setFoodCode(String foodCode)
    {
        this.foodCode = foodCode;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public double getFoodPrice()
    {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice)
    {
        this.foodPrice = foodPrice;
    }

    public Date getCreateDate()
    {
        return produceDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.produceDate = createDate;
    }

    public Date getExpiredDate()
    {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate)
    {
        this.expiredDate = expiredDate;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Food{" +
                "foodCode='" + foodCode + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", producedDate=" + produceDate +
                ", expieredDate=" + expiredDate +
                '}';
    }
}
