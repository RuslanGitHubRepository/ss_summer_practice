package com.simbirsoft.practice;

import com.simbirsoft.entity.PageStatus;
import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MariaDBRepository implements DataBaseRepository {
    private final MariaDbPoolDataSource pool;
    private final String URL = "jdbc:mariadb://localhost/summer_practic?user=%s&password=%s&maxPoolSize=%d";
    private final String LOGIN = "root";
    private final String PASSWORD = "write";
    private final Integer POOL_SIZE = 10;
    private final String INSERT_QUERY = "INSERT INTO PAGE_STATUS (PAGE_NAME, URL_PAGE, DOWNLOAD) VALUES ('%s', '%s', %s)";

    public MariaDBRepository() throws SQLException {
        pool = new MariaDbPoolDataSource(String.format(URL, LOGIN, PASSWORD, POOL_SIZE));
    }

    @Override
    public void savePageStatus(PageStatus pageStatus) throws SQLException {
        try (Connection connection = pool.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(String.format(
                        INSERT_QUERY,
                        pageStatus.getPageName(),
                        pageStatus.getUrlPage(),
                        pageStatus.getDownLoad())
                );
            }
        }
    }
}
