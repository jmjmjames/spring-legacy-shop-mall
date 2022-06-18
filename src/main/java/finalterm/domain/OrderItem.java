package finalterm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderItem {

    private String itemName;
    private Integer price;
    private String dType;
    private String company;
    private Integer orderPrice;
    private Integer orderCount;
    private Timestamp orderDate;

    public OrderItem(String itemName, Integer price, String dType, String company, Integer orderPrice, Integer orderCount, Timestamp orderDate) {
        this.itemName = itemName;
        this.price = price;
        this.dType = dType;
        this.company = company;
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
        this.orderDate = orderDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
