package finalterm.repository;

import finalterm.domain.User;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {

    private final static String INSERT_QUERY = "insert into USER values(?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_QUERY = "update USER set email = ?, address = ?, phoneNumber = ? where userId = ?";
    private final static String DELETE_QUERY = "delete from USER where userId = ?";
    private final static String SELECT_QUERY = "select * from USER where userId = ?";

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        jdbcTemplate.update(INSERT_QUERY, null, user.getUserId(), user.getPwd(), user.getName(),
                user.getBirthday(), user.getEmail(), user.getAddress(), user.getPhoneNumber());
    }

    public void update(User user) {
        jdbcTemplate.update(UPDATE_QUERY, user.getEmail(), user.getAddress(), user.getPhoneNumber(), user.getUserId());
    }

    public void delete(String userId) {
        jdbcTemplate.update(DELETE_QUERY, userId);
    }

    public User findByUserId(String userId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_QUERY, (rs, rowNum) ->
                    new User(rs.getInt("id"), rs.getString("userId"), rs.getString("pwd"),
                            rs.getString("name"), rs.getDate("birthDay").toLocalDate(), rs.getString("email"),
                            rs.getString("address"), rs.getString("phoneNumber")), userId);
        } catch (IncorrectResultSizeDataAccessException error) {
            return null;
        }
    }

    public User findByEmail(String email) {
        try {
            String sql = "select * from USER WHERE email = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new User(rs.getInt("id"), rs.getString("userId"), rs.getString("pwd"),
                            rs.getString("name"), rs.getDate("birthDay").toLocalDate(), rs.getString("email"),
                            rs.getString("address"), rs.getString("phoneNumber")), email);
        } catch (IncorrectResultSizeDataAccessException error) {
            return null;
        }
    }

    public User findByPhoneNumber(String phoneNumber) {
        try {
            String sql = "select * from USER WHERE phoneNumber = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new User(rs.getInt("id"), rs.getString("userId"), rs.getString("pwd"),
                            rs.getString("name"), rs.getDate("birthDay").toLocalDate(), rs.getString("email"),
                            rs.getString("address"), rs.getString("phoneNumber")), phoneNumber);
        } catch (IncorrectResultSizeDataAccessException error) {
            return null;
        }
    }
}
