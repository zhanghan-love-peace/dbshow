package com.imjava.dbshow.servlets;

import com.imjava.dbshow.dbutils.QueryIndex;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/all-first-index")
public class QueryFirstIndex extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("all-first-index servlet called");
        List<String> result;
        result = QueryIndex.getAllFirstIndex();

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        for (String s : result) {
            writer.println(s);
        }

        writer.flush();
        writer.close();
    }
}