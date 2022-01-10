package com.imjava.dbshow.dbutils;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager implements AutoCloseable {
    String jdbcUrl;
    String jdbcUsername;
    String jdbcPassword;
    Connection connect;
    DSLContext dslContext;

    public DbManager() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        jdbcUrl = "jdbc:mysql://129.211.91.153:3306/dbshow";
        jdbcUsername = "dbshow";
        jdbcPassword = "dbshow";

        connect = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        dslContext = DSL.using(connect, SQLDialect.MYSQL);
    }

    @Override
    public void close() throws Exception {
        connect.close();
        dslContext.close();
    }
}
