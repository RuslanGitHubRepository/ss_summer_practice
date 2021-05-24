package com.simbirsoft.practice;

import com.simbirsoft.entity.PageStatus;
import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MariaDBRepository implements DataBaseRepository {
    private final MariaDbPoolDataSource pool;

    public MariaDBRepository() throws SQLException {
        pool = new MariaDbPoolDataSource("jdbc:mariadb://server/db?user=myUser&maxPoolSize=10");
    }

    @Override
    public void savePageStatus(PageStatus pageStatus) throws SQLException {
        try (Connection connection = pool.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.execute("INSERT")
                rs.next();
                System.out.println(rs.getLong(1)); //4489
            }
        }
    }
}
