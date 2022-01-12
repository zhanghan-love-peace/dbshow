package com.imjava.dbshow.servlets.ManageIndex;

import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.dbutils.ManageIndex;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/delete-index")
public class DeleteIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("delete-index servlet called");
        // setting http
        resp.setContentType("text/plain;charset=UTF-8");
        // init writer
        int level = Integer.parseInt(req.getParameter("level"));
        int indexId = Integer.parseInt(req.getParameter("index_id"));

        PrintWriter writer = resp.getWriter();

        ManageIndex.deleteIndex(level, indexId);

        JSONObject returnObj = new JSONObject();
        returnObj.put("code", 1);
        writer.println(returnObj);

        writer.flush();
        writer.close();
    }
}
