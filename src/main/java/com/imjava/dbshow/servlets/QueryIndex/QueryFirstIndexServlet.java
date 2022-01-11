package com.imjava.dbshow.servlets.QueryIndex;

import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.dbutils.QueryIndex;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/first-index")
public class QueryFirstIndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("first-index servlet called");
        // setting http
        resp.setContentType("text/plain;charset=UTF-8");
        // init writer
        PrintWriter writer = resp.getWriter();

        List<JSONObject> resultList = QueryIndex.getAllThirdIndex();

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", resultList);
        returnObj.put("code", 0);
        writer.println(returnObj);

        writer.flush();
        writer.close();
    }
}