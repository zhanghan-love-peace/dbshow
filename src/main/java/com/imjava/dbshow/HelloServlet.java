package com.imjava.dbshow;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.imjava.dbshow.db.tables.Metrics;
import com.imjava.dbshow.db.tables.records.MetricsRecord;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        testJooq();

        // Hello
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("hello!");
        writer.close();
    }

    public void testJooq() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/dbshow";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

        System.out.println("print test");

        // 获取 JDBC 链接
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            // 获取 jOOQ 执行器
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);

            // fetch方法可以返回一个结果集对象 Result
            // jOOQ的Result对象实现了List接口，可以直接当做集合使用
            Result<Record> recordResult = dslContext.select().from(Metrics.METRICS).fetch();
            recordResult.forEach(record -> {
                Integer id = record.getValue(Metrics.METRICS.ID);
                String metricType = record.getValue(Metrics.METRICS.METRIC_TYPE);
                System.out.println("fetch Record     id: " + id + " , metric_type: " + metricType);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}