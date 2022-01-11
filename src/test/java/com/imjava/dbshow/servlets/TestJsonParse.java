package com.imjava.dbshow.servlets;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class TestJsonParse {
    public static void main(String[] args) {
        List<String> parsedList = JSONObject.parseArray("['2018', '2019']", String.class);
        // System.out.println(parsedList.toJSONString());
    }
}
