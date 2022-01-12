package com.imjava.dbshow.dbutils;

import com.imjava.dbshow.db.tables.records.FirstIndexRecord;
import com.imjava.dbshow.db.tables.records.SecondIndexRecord;
import com.imjava.dbshow.db.tables.records.ThirdIndexRecord;

import static com.imjava.dbshow.db.Tables.*;

public class ManageIndex {
    public static int AddIndex(int level, String indexName, int fatherId) {
        int returnId = -1;
        try (DbManager mng = new DbManager()) {
            if (level == 1) {
                FirstIndexRecord result = mng.dslContext
                        .insertInto(FIRST_INDEX, FIRST_INDEX.NAME)
                        .values(indexName)
                        .returning(FIRST_INDEX.ID)
                        .fetchOne();
                returnId = result.getValue(FIRST_INDEX.ID);
            } else if (level == 2) {
                SecondIndexRecord result = mng.dslContext
                        .insertInto(SECOND_INDEX, SECOND_INDEX.NAME, SECOND_INDEX.FIRST_INDEX_ID)
                        .values(indexName, fatherId)
                        .returning(SECOND_INDEX.ID)
                        .fetchOne();
                returnId = result.getValue(SECOND_INDEX.ID);
            } else if (level == 3) {
                ThirdIndexRecord result = mng.dslContext
                        .insertInto(THIRD_INDEX, THIRD_INDEX.NAME, THIRD_INDEX.SECOND_INDEX_ID)
                        .values(indexName, fatherId)
                        .returning(THIRD_INDEX.ID)
                        .fetchOne();
                returnId = result.getValue(THIRD_INDEX.ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnId;
    }

    public static int deleteIndex(int level, int indexId) {
        try (DbManager mng = new DbManager()) {
            if (level == 1) {
                mng.dslContext.delete(FIRST_INDEX)
                        .where(FIRST_INDEX.ID.eq(indexId))
                        .execute();
            } else if (level == 2) {
                mng.dslContext.delete(SECOND_INDEX)
                        .where(SECOND_INDEX.ID.eq(indexId))
                        .execute();
            } else if (level == 3) {
                mng.dslContext.delete(THIRD_INDEX)
                        .where(THIRD_INDEX.ID.eq(indexId))
                        .execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;  // success
    }

    public static int modifyIndex(int level, int indexId, String changeName) {
        try (DbManager mng = new DbManager()) {
            if (level == 1) {
                mng.dslContext.update(FIRST_INDEX)
                        .set(FIRST_INDEX.NAME, changeName)
                        .where(FIRST_INDEX.ID.eq(indexId))
                        .execute();
            } else if (level == 2) {
                mng.dslContext.update(SECOND_INDEX)
                        .set(SECOND_INDEX.NAME, changeName)
                        .where(SECOND_INDEX.ID.eq(indexId))
                        .execute();
            } else if (level == 3) {
                mng.dslContext.update(THIRD_INDEX)
                        .set(THIRD_INDEX.NAME, changeName)
                        .where(THIRD_INDEX.ID.eq(indexId))
                        .execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;  // success
    }
}
