package com.imjava.dbshow.dbutils;

import static com.imjava.dbshow.db.Tables.DATA;
import static com.imjava.dbshow.db.Tables.THIRD_INDEX;

import org.jooq.Record4;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

public class QueryData {
    public static List<IndexData> queryThirdData(List<String> years, List<String> indexNames, List<String> countries) {
        List<IndexData> result = new ArrayList<>();
        try (DbManager mng = new DbManager()) {
            Result<Record4<String, String, String, Double>> recordResult = mng.dslContext
                    .select(DATA.COUNTRY, DATA.YEAR, THIRD_INDEX.NAME, DATA.DATA_)
                    .from(DATA)
                    .leftOuterJoin(THIRD_INDEX)
                    .on(DATA.THIRD_INDEX_ID.eq(THIRD_INDEX.ID))
                    .where(DATA.COUNTRY.in(countries).and(DATA.YEAR.in(years)).and(THIRD_INDEX.NAME.in(indexNames)))
                    .fetch();
            for (Record4<String, String, String, Double> record : recordResult) {
                IndexData indexData = new IndexData(record.getValue(DATA.YEAR), record.getValue(DATA.DATA_), record.getValue(DATA.COUNTRY), record.getValue(THIRD_INDEX.NAME));
                result.add(indexData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

