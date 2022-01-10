package com.imjava.dbshow.dbutils;

import static com.imjava.dbshow.db.Tables.FIRST_INDEX;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

public class QueryIndex {
    /**
     * 获取所有的第一指标名称
     * @return List of FirstIndexName (String)
     */
    public static List<String> getAllFirstIndex() {
        List<String> result = new ArrayList<>();
        try (DbManager mng = new DbManager()) {
            Result<Record> recordResult = mng.dslContext.select().from(FIRST_INDEX).fetch();
            for (Record record : recordResult) {
                int id = record.getValue(FIRST_INDEX.ID);
                String name = record.getValue(FIRST_INDEX.NAME);
                result.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
