package finalterm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/jdbctest?serverTimezone=UTC&CharacterEncoding=utf8");
        dataSource.setUsername("james");
        dataSource.setPassword("james1234");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);
        return dataSource;
    }
}
