package lk.ijse.dep.web.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

public class JpaUtil {
    static Logger logger = LoggerFactory.getLogger(JpaUtil.class);

    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        Properties properties = new Properties();

        try {
            properties.load(JpaUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.put(Environment.DATASOURCE, getDataSource());

        entityManagerFactory = Persistence.createEntityManagerFactory("dep-6", properties);

        return entityManagerFactory;
    }


    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private static DataSource getDataSource() {

        BasicDataSource basicDataSource = null;
        try {
            Properties properties = new Properties();
            properties.load(JpaUtil.class.getResourceAsStream("/application.properties"));
            basicDataSource = new BasicDataSource();
            basicDataSource.setInitialSize(5);
            basicDataSource.setMaxTotal(10);
            basicDataSource.setDriverClassName(properties.getProperty("dbcp.connection.driver_class"));
            basicDataSource.setUrl(properties.getProperty("dbcp.connection.url"));
            basicDataSource.setUsername(properties.getProperty("dbcp.connection.username"));
            basicDataSource.setPassword(properties.getProperty("dbcp.connection.password"));

            return basicDataSource;
        } catch (IOException e) {
//            e.printStackTrace();
            logger.warn("Error occurred in Connection settings");
            throw new RuntimeException(e);
        }


    }
}
