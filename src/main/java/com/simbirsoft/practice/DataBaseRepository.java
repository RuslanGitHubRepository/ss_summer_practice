package com.simbirsoft.practice;

import com.simbirsoft.entity.PageStatus;

import java.sql.SQLException;

public interface DataBaseRepository {
    void savePageStatus(PageStatus pageStatus) throws SQLException;
}
