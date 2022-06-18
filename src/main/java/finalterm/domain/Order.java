package finalterm.domain;


import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer itemId;
    private Integer orderPrice;
    private Integer orderCount;
    private LocalDateTime orderDate;

    public Order() {
        this.id = null;
    }

    public static Order createOrder(int userId, Item item, int orderCount) {
        Order order = new Order();
        order.setUserId(userId);
        order.setItemId(item.getId());
        order.setOrderPrice(item.getPrice() * orderCount);
        order.setOrderCount(orderCount);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
