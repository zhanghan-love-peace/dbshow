package com.imjava.dbshow.dbutils;

import com.alibaba.fastjson.JSONObject;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static com.imjava.dbshow.db.Tables.*;

public class QueryIndex {
    /**
     * 获取所有的第一指标名称
     * @return List of FirstIndexName (String)
     */
    public static List<JSONObject> getAllFirstIndex() {
        List<JSONObject> resultList = new ArrayList<>();
        try (DbManager mng = new DbManager()) {
            Result<Record> recordResult = mng.dslContext.select().from(FIRST_INDEX).fetch();
            for (Record record : recordResult) {
                int id = record.getValue(FIRST_INDEX.ID);
                String name = record.getValue(FIRST_INDEX.NAME);

                JSONObject indexObj = new JSONObject();
                indexObj.put("id", id);
                indexObj.put("name", name);
                resultList.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 获取所有的第二指标的名称
     * @return List of SecondIndexName (String)
     */
    public static List<JSONObject> getAllSecondIndex() {
        List<JSONObject> resultList = new ArrayList<>();
        try (DbManager mng = new DbManager()) {
            Result<Record> recordResult = mng.dslContext
                    .select()
                    .from(SECOND_INDEX)
                    .fetch();
            // go through query result
            for (Record record : recordResult) {
                int id = record.getValue(SECOND_INDEX.ID);
                String name = record.getValue(SECOND_INDEX.NAME);
                int father = record.getValue(SECOND_INDEX.FIRST_INDEX_ID);

                JSONObject indexObj = new JSONObject();
                indexObj.put("id", id);
                indexObj.put("name", name);
                indexObj.put("father", father);

                resultList.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 获取所有的第三指标的名称
     * @return List of ThirdIndexName (String)
     */
    public static List<JSONObject> getAllThirdIndex() {
        List<JSONObject> resultList = new ArrayList<>();
        try (DbManager mng = new DbManager()) {
            Result<Record> recordResult = mng.dslContext
                    .select()
                    .from(THIRD_INDEX)
                    .fetch();
            for (Record record : recordResult) {
                int id = record.getValue(THIRD_INDEX.ID);
                String name = record.getValue(THIRD_INDEX.NAME);
                int father = record.getValue(THIRD_INDEX.SECOND_INDEX_ID);

                JSONObject indexObj = new JSONObject();
                indexObj.put("id",id);
                indexObj.put("name",name);
                indexObj.put("father",father);

                resultList.add(indexObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
