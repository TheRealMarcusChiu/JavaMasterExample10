package database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
public class PlatformTransactionManagerExample {

    private static final String SQL_QUERY_UPDATE = "update user u set u.name = ?, u.submission_date = now(), u.last_modified = now() where u.id = ?";

    public JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource dbConn = new DriverManagerDataSource();

        dbConn.setDriverClassName("com.mysql.jdbc.Driver"); // need mysql/mysql-connector-java/5.1.6 in pom.xml
        dbConn.setUrl("jdbc:mysql://localhost:3306/Example");
        dbConn.setUsername("root");
        dbConn.setPassword("password");

        return new JdbcTemplate(dbConn);
    }

    public Boolean test(JdbcTemplate jdbcTemplate, int id, String name) {

        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(jdbcTemplate.getDataSource());
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());

        try {

            jdbcTemplate.update(SQL_QUERY_UPDATE, name, id);

            platformTransactionManager.commit(transactionStatus);

        } catch (Exception exception) {

            exception.printStackTrace();
            System.out.println("Database error in updateStatusToRedeem! Rolling back.");

            platformTransactionManager.rollback(transactionStatus);
            return false;
        }

        return true;
    }

    public static void main(String args[]) {
        PlatformTransactionManagerExample platformTransactionManagerExample = new PlatformTransactionManagerExample();

        JdbcTemplate jdbcTemplate = platformTransactionManagerExample.getJdbcTemplate();
        platformTransactionManagerExample.test(jdbcTemplate, 2, "jiggly puff");
    }
}
