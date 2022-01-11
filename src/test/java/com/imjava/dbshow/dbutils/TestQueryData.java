package com.imjava.dbshow.dbutils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQueryData {
    public static void main(String[] args) {
        testQueryThirdData();
        testQuerySecondData();
        testQueryFirstData();
    }

    public static void testQueryThirdData() {
        List<String> sampleYear = new ArrayList<>(Arrays.asList("2018", "2019"));
        List<String> sampleCountry = new ArrayList<>(Arrays.asList("美国", "中国"));
        List<Integer> sampleIndex = new ArrayList<>(Arrays.asList(1, 2));

        JSONArray result = QueryData.queryThirdData(sampleYear, sampleIndex, sampleCountry);
        System.out.println(result.toJSONString());
    }

    public static void testQuerySecondData() {
        List<String> sampleYear = new ArrayList<>(Arrays.asList("2018", "2019"));
        List<String> sampleCountry = new ArrayList<>(Arrays.asList("美国", "中国"));
        List<Integer> sampleIndex = new ArrayList<>(Arrays.asList(1, 2));

        JSONArray result = QueryData.querySecondData(sampleYear, sampleIndex, sampleCountry);
        System.out.println(result.toJSONString());
    }

    public static void testQueryFirstData() {
        List<String> sampleYear = new ArrayList<>(Arrays.asList("2018", "2019"));
        List<String> sampleCountry = new ArrayList<>(Arrays.asList("美国", "中国"));
        List<Integer> sampleIndex = new ArrayList<>(Arrays.asList(1, 2));

        JSONArray result = QueryData.queryFirstData(sampleYear, sampleIndex, sampleCountry);
        System.out.println(result.toJSONString());
    }
}
