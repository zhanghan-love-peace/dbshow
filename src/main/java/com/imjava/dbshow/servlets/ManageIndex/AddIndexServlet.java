package com.imjava.dbshow.servlets.ManageIndex;

import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.dbutils.ManageIndex;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add-index")
public class AddIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("add-index servlet called");
        // setting http
        resp.setContentType("text/plain;charset=UTF-8");
        // init writer
        int level = Integer.parseInt(req.getParameter("level"));
        int fatherId = Integer.parseInt(req.getParameter("father_id"));
        String indexName = req.getParameter("index_name");

        PrintWriter writer = resp.getWriter();

        int returnId = ManageIndex.AddIndex(level, indexName, fatherId);

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", returnId);
        returnObj.put("code", 1);
        writer.println(returnObj);

        writer.flush();
        writer.close();
    }
}
