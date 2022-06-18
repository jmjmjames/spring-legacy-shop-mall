package finalterm.repository;

import finalterm.domain.Item;
import finalterm.domain.User;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Item item) {
        String sql = "insert into item values(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, item.getName(), item.getPrice(), item.getStockQuantity(),
                item.getdType(), item.getCompany(), item.getDetail());
    }

    public List<Item> findAll() {
        String sql = "SELECT * FROM Item";
        List<Item> items = jdbcTemplate.query(sql, iterMapper);
        return !items.isEmpty() ? items : null;
    }

    public List<Item> findByType(String dType) {
        String sql = "SELECT * FROM Item where dType = ?";
        List<Item> items = jdbcTemplate.query(sql, iterMapper, dType);
        return !items.isEmpty() ? items : null;
    }

    public List<Item> findByName(String name) {
        String sql = "SELECT * FROM Item where name = ?";
        List<Item> items = jdbcTemplate.query(sql, iterMapper, name);
        return !items.isEmpty() ? items : null;
    }

    public Item findById(Integer id) {
        try {
            String sql = "select * from ITEM WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, iterMapper, id);
        } catch (IncorrectResultSizeDataAccessException error) {
            return null;
        }
    }

    public List<Item> findByCompany(String company) {
        String sql = "SELECT * FROM Item where company = ?";
        List<Item> items = jdbcTemplate.query(sql, iterMapper, company);
        return !items.isEmpty() ? items : null;
    }

    public void removeStock(Item item, int count) {
        String sql = "update item set stockQuantity = ? where id = ?";
        jdbcTemplate.update(sql, (item.getStockQuantity() - count), item.getId());
    }

    public void addStock(Item item, int count) {
        String sql = "update item set stockQuantity = ? where id = ?";
        jdbcTemplate.update(sql, (item.getStockQuantity() + count), item.getId());
    }

    static RowMapper<Item> iterMapper = ((rs, rowNum) -> new Item(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("price"),
            rs.getInt("stockQuantity"),
            rs.getString("dType"),
            rs.getString("company"),
            rs.getString("detail")
    ));
}
