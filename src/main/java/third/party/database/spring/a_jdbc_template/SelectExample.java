package third.party.database.spring.a_jdbc_template;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

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
public class SelectExample {

    public static JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource dbConn = new DriverManagerDataSource();

        dbConn.setDriverClassName("com.mysql.jdbc.Driver"); // need mysql/mysql-connector-java/5.1.6 in pom.xml
        dbConn.setUrl("jdbc:mysql://localhost:3306/Example");
        dbConn.setUsername("root");
        dbConn.setPassword("password");

        return new JdbcTemplate(dbConn);
    }

    @Test
    public void queryList() {

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        List<Map<String, Object>> results;
        results = jdbcTemplate.queryForList("SELECT * FROM user u LIMIT ?", 3);

        if (results != null && results.size() > 0) {

            for ( int i = 0; i < results.size(); i++) {

                Map<String, Object> row = results.get(i);

                String name = String.valueOf(row.get("name"));
                String lastModified = String.valueOf(row.get("last_modified"));

                System.out.println(name + " : " + lastModified);
            }
        }
    }
}
