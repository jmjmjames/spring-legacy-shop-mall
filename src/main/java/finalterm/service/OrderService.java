package finalterm.service;

import finalterm.domain.Item;
import finalterm.domain.Order;
import finalterm.domain.OrderItem;
import finalterm.domain.User;
import finalterm.repository.ItemRepository;
import finalterm.repository.OrderRepository;
import finalterm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public Order order(String userId, Integer itemId, Integer count) {
        User user = userRepository.findByUserId(userId);
        Item item = itemRepository.findById(itemId);

        // 주문 생성
        Order order = Order.createOrder(user.getId(), item, count);
        orderRepository.save(order);
        itemRepository.removeStock(item, count);
        return order;
    }

    public Item findItemName(Integer itemId) {
        return itemRepository.findById(itemId);
    }

    public List<OrderItem> findByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        List<OrderItem> orderItems = orderRepository.findOrderItem(user.getId());
        return orderItems;
    }

    public List<OrderItem> findByItemName(String userId, String itemName) {
        User user = userRepository.findByUserId(userId);
        List<Item> item = itemRepository.findByName(itemName);
        if (item == null) {
            return null;
        }
        return orderRepository.findOrderItemByItemName(user.getId(), item.get(0).getId());
    }

    public List<OrderItem> findByDate(String userId, String startDate, String endDate) {
        User user = userRepository.findByUserId(userId);

        return orderRepository.findOrderItemByDate(user.getId(),startDate, endDate);
    }
}
