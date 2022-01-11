package com.imjava.dbshow.servlets.QueryData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.dbutils.IndexData;
import com.imjava.dbshow.dbutils.QueryData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/third-data")
public class QueryThirdDataServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        // how to fix the utf8 problem
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        System.out.println("third-data servlet called");

        JSONArray result;

        // how to convert string to list
        List<String> sampleYear = JSONObject.parseArray(req.getParameter("years"), String.class);
        List<String> sampleCountry = JSONObject.parseArray(req.getParameter("countries"), String.class);
        List<Integer> sampleIndex = JSONObject.parseArray(req.getParameter("indexes"), Integer.class);

        sampleYear.forEach(System.out::println);
        sampleCountry.forEach(System.out::println);
        sampleIndex.forEach(System.out::println);

        result = QueryData.queryThirdData(sampleYear, sampleIndex, sampleCountry);

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", result);
        returnObj.put("code", 1);

        writer.println(returnObj.toJSONString());
        writer.flush();
        writer.close();
    }
}