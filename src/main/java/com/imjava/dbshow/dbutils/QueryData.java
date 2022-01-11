package com.imjava.dbshow.dbutils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imjava.dbshow.db.tables.Data;
import com.imjava.dbshow.db.tables.SecondIndex;
import com.imjava.dbshow.db.tables.records.DataRecord;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.Result;
import org.jooq.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.imjava.dbshow.db.Tables.*;
import static org.jooq.impl.DSL.avg;

public class QueryData {
    public static JSONArray queryThirdData(List<String> years, List<Integer> indexIds, List<String> countries) {
        // convert string to int
        // List<Integer> indexIds = new ArrayList<>();
        // indexIdsStr.forEach(idStr -> indexIds.add(Integer.parseInt(idStr)));

        JSONArray result = new JSONArray();
        try (DbManager mng = new DbManager()) {
            Result<Record4<String, String, Integer, Double>> recordResult = mng.dslContext
                    .select(DATA.COUNTRY, DATA.YEAR, THIRD_INDEX.ID, DATA.DATA_)
                    .from(DATA)
                    .leftOuterJoin(THIRD_INDEX)
                    .on(DATA.THIRD_INDEX_ID.eq(THIRD_INDEX.ID))
                    .where(DATA.COUNTRY.in(countries).and(DATA.YEAR.in(years)).and(THIRD_INDEX.ID.in(indexIds)))
                    .fetch();
            for (Record4<String, String, Integer, Double> record : recordResult) {
                JSONObject indexObj = new JSONObject();
                indexObj.put("year", record.getValue(DATA.YEAR));
                indexObj.put("country", record.getValue(DATA.COUNTRY));
                indexObj.put("data", record.getValue(DATA.DATA_));
                indexObj.put("id", record.getValue(THIRD_INDEX.ID));
                result.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONArray querySecondData(List<String> years, List<Integer> indexIds, List<String> countries) {
        JSONArray result = new JSONArray();
        try (DbManager mng = new DbManager()) {
            Result<Record4<String, String, Integer, BigDecimal>> recordResult = mng.dslContext
                    .select(DATA.COUNTRY, DATA.YEAR, THIRD_INDEX.SECOND_INDEX_ID, avg(DATA.DATA_))
                    .from(DATA)
                    .leftOuterJoin(THIRD_INDEX)
                    .on(DATA.THIRD_INDEX_ID.eq(THIRD_INDEX.ID))
                    .where(DATA.COUNTRY.in(countries).and(DATA.YEAR.in(years)).and(THIRD_INDEX.SECOND_INDEX_ID.in(indexIds)))
                    .groupBy(DATA.COUNTRY, DATA.YEAR, THIRD_INDEX.SECOND_INDEX_ID)
                    .fetch();
            for (Record4<String, String, Integer, BigDecimal> record : recordResult) {
                JSONObject indexObj = new JSONObject();
                indexObj.put("year", record.getValue(DATA.YEAR));
                indexObj.put("country", record.getValue(DATA.COUNTRY));
                indexObj.put("data", record.getValue(avg(DATA.DATA_)));
                indexObj.put("id", record.getValue(THIRD_INDEX.SECOND_INDEX_ID));
                result.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONArray queryFirstData(List<String> years, List<Integer> indexIds, List<String> countries) {
        JSONArray result = new JSONArray();
        try (DbManager mng = new DbManager()) {
            Table<?> secondIndexData = mng.dslContext
                    .select(DATA.COUNTRY, DATA.YEAR, SECOND_INDEX.FIRST_INDEX_ID, avg(DATA.DATA_).as("SECOND_DATA"))
                    .from(DATA)
                    .leftOuterJoin(THIRD_INDEX)
                    .on(DATA.THIRD_INDEX_ID.eq(THIRD_INDEX.ID))
                    .leftOuterJoin(SECOND_INDEX)
                    .on(THIRD_INDEX.SECOND_INDEX_ID.eq(SECOND_INDEX.ID))
                    .where(DATA.COUNTRY.in(countries).and(DATA.YEAR.in(years)).and(THIRD_INDEX.SECOND_INDEX_ID.in(indexIds)))
                    .groupBy(DATA.COUNTRY, DATA.YEAR, SECOND_INDEX.ID)  // group by second index
                    .asTable("secondIndexData");

            Result<?> recordResult = mng.dslContext
                    .selectFrom(secondIndexData)
                    .groupBy(secondIndexData.field(0), secondIndexData.field(1), secondIndexData.field(2))
                    .fetch();

            for (Record record : recordResult) {
                JSONObject indexObj = new JSONObject();
                indexObj.put("country", record.getValue(secondIndexData.field(0)));
                indexObj.put("year", record.getValue(secondIndexData.field(1)));
                indexObj.put("id", record.getValue(secondIndexData.field(2)));  // first index id
                indexObj.put("data", record.getValue(secondIndexData.field(3)));
                result.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

