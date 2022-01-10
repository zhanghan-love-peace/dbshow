package com.imjava.dbshow.servlets;

import com.imjava.dbshow.dbutils.IndexData;
import com.imjava.dbshow.dbutils.QueryData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet("/third-data")
public class QueryThirdData extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("third-data servlet called");
        List<IndexData> result;
        List<String> sampleYear = new ArrayList<>(Arrays.asList("2018", "2019"));
        List<String> sampleCountry = new ArrayList<>(Arrays.asList("美国", "中国"));
        List<String> sampleIndex = new ArrayList<>(Arrays.asList("互联网用户的平均上网带宽", "每千名互联网用户的平均国际互联网出口宽带"));
        result = QueryData.queryThirdData(sampleYear, sampleIndex, sampleCountry);

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        for (IndexData indexData : result) {
            writer.println(indexData.getString());
        }

        writer.flush();
        writer.close();
    }
}