package com.imjava.dbshow.dbutils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class TestQueryIndex {
    public static void main(String[] args) {
        testQueryFirstIndex();
        testQuerySecondIndex();
        testQueryThirdIndex();
    }

    private static void testQueryFirstIndex() {
        List<JSONObject> resultList = QueryIndex.getAllFirstIndex();

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", resultList);
        returnObj.put("code", 0);

        System.out.println(returnObj);
    }

    private static void testQuerySecondIndex() {
        List<JSONObject> resultList = QueryIndex.getAllSecondIndex();

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", resultList);
        returnObj.put("code", 0);

        System.out.println(returnObj);
    }

    private static void testQueryThirdIndex() {
        List<JSONObject> resultList = QueryIndex.getAllThirdIndex();

        JSONObject returnObj = new JSONObject();
        returnObj.put("result", resultList);
        returnObj.put("code", 0);

        System.out.println(returnObj);
    }
}
