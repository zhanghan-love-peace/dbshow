package com.imjava.dbshow.servlets.QueryIndex;

import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.dbutils.QueryIndex;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/second-index")
public class QuerySecondIndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("second-index servlet called");
        // setting http
        resp.setContentType("text/plain;charset=UTF-8");
        // init writer
        PrintWriter writer = resp.getWriter();

        List<JSONObject> resultList = QueryIndex.getAllSecondIndex();

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", resultList);
        returnObj.put("code", 0);
        writer.println(returnObj);

        writer.flush();
        writer.close();
    }
}