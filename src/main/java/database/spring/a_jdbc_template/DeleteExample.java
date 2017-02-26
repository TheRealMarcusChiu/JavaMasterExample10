package database.spring.a_jdbc_template;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Example use of PlatformTransactionManager
 * commit and rollback
 * Have a MySQL server running at port 3306
 * Have a database named Example
 * Have a user table within that database
 * Below is the DDL
 *****************************************************
 * CREATE TABLE user
 * (
 *  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 *  name VARCHAR(100) NOT NULL,
 *  submission_date DATE,
 *  last_modified DATETIME DEFAULT CURRENT_TIMESTAMP
 * );
 *****************************************************
 */
public class DeleteExample {

    public JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource dbConn = new DriverManagerDataSource();

        dbConn.setDriverClassName("com.mysql.jdbc.Driver"); // need mysql/mysql-connector-java/5.1.6 in pom.xml
        dbConn.setUrl("jdbc:mysql://localhost:3306/Example");
        dbConn.setUsername("root");
        dbConn.setPassword("password");

        return new JdbcTemplate(dbConn);
    }

    @Test
    public void delete() {

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        int result;
        result = jdbcTemplate.update("DELETE FROM user WHERE name = ?", "Jesus Christ");

        System.out.println(Integer.toString(result));
    }
}
