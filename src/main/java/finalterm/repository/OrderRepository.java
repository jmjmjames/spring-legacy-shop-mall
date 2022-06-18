package finalterm.repository;

import finalterm.domain.Item;
import finalterm.domain.Order;
import finalterm.domain.OrderItem;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Order order) {
        String sql = "insert into ORDERS values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getUserId(), order.getItemId(), order.getOrderPrice(), order.getOrderCount(), order.getOrderDate());
    }

    public List<OrderItem> findOrderItem(Integer userId) {
        String sql = "select I.name, I.price, I.dType, I.company, O.orderPrice, O.orderCount, O.orderDate from Orders O join Item I ON O.itemId = I.id where userId = ?";
        return jdbcTemplate.query(sql, iterMapper, userId);
    }

    public List<OrderItem> findOrderItemByItemName(Integer userId, Integer itemId) {
        String sql = "select I.name, I.price, I.dType, I.company, O.orderPrice, O.orderCount, O.orderDate from Orders O join Item I ON O.itemId = I.id where userId = ? AND I.id = ?";
        return jdbcTemplate.query(sql, iterMapper, userId, itemId);
    }

    public List<OrderItem> findOrderItemByDate(Integer userId, String startDate, String endDate) {
        String sql = "select I.name, I.price, I.dType, I.company, O.orderPrice, O.orderCount, O.orderDate from Orders O join Item I ON O.itemId = I.id where userId = ? AND DATE(orderDate) BETWEEN ? and ?";
        return jdbcTemplate.query(sql, iterMapper, userId, startDate, endDate);
    }

    public void deleteByUserId(Integer id) {
        String sql = "delete from Orders where userId = ?";
        jdbcTemplate.update(sql, id);
    }

    static RowMapper<OrderItem> iterMapper = ((rs, rowNum) -> new OrderItem(
            rs.getString("I.name"),
            rs.getInt("I.price"),
            rs.getString("I.dType"),
            rs.getString("I.company"),
            rs.getInt("O.orderPrice"),
            rs.getInt("O.orderCount"),
            rs.getTimestamp("O.orderDate")
    ));

}
