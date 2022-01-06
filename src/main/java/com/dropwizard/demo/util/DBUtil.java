package com.dropwizard.demo.util;

import javax.sql.DataSource;
import com.dropwizard.demo.configuration.DBConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

    private static HikariDataSource dataSource;
    private static HikariConfig config = new HikariConfig();

    public static DataSource getDataSource(DBConfiguration dbConfig){
        if(dataSource == null){
            prepareDataSource(dbConfig);
        }
        return dataSource;
    }

    private static void prepareDataSource(DBConfiguration dbConfig) {
        config.setJdbcUrl(dbConfig.getDbUrl());
        config.setUsername(dbConfig.getDbUserName());
        config.setPassword(dbConfig.getDbPassword());
        config.setDriverClassName(dbConfig.getDriverClassName());
        dataSource = new HikariDataSource(config);
    }
}