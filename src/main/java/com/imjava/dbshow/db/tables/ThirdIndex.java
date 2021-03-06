/*
 * This file is generated by jOOQ.
 */
package com.imjava.dbshow.db.tables;


import com.imjava.dbshow.db.Dbshow;
import com.imjava.dbshow.db.Indexes;
import com.imjava.dbshow.db.Keys;
import com.imjava.dbshow.db.tables.records.ThirdIndexRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 三级指标
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ThirdIndex extends TableImpl<ThirdIndexRecord> {

    private static final long serialVersionUID = -1780051362;

    /**
     * The reference instance of <code>dbshow.third_index</code>
     */
    public static final ThirdIndex THIRD_INDEX = new ThirdIndex();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ThirdIndexRecord> getRecordType() {
        return ThirdIndexRecord.class;
    }

    /**
     * The column <code>dbshow.third_index.id</code>.
     */
    public final TableField<ThirdIndexRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>dbshow.third_index.name</code>.
     */
    public final TableField<ThirdIndexRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>dbshow.third_index.second_index_id</code>.
     */
    public final TableField<ThirdIndexRecord, Integer> SECOND_INDEX_ID = createField(DSL.name("second_index_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>dbshow.third_index</code> table reference
     */
    public ThirdIndex() {
        this(DSL.name("third_index"), null);
    }

    /**
     * Create an aliased <code>dbshow.third_index</code> table reference
     */
    public ThirdIndex(String alias) {
        this(DSL.name(alias), THIRD_INDEX);
    }

    /**
     * Create an aliased <code>dbshow.third_index</code> table reference
     */
    public ThirdIndex(Name alias) {
        this(alias, THIRD_INDEX);
    }

    private ThirdIndex(Name alias, Table<ThirdIndexRecord> aliased) {
        this(alias, aliased, null);
    }

    private ThirdIndex(Name alias, Table<ThirdIndexRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("三级指标"));
    }

    public <O extends Record> ThirdIndex(Table<O> child, ForeignKey<O, ThirdIndexRecord> key) {
        super(child, key, THIRD_INDEX);
    }

    @Override
    public Schema getSchema() {
        return Dbshow.DBSHOW;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.THIRD_INDEX_PRIMARY, Indexes.THIRD_INDEX_THIRD_INDEX_SECOND_INDEX_ID_FK);
    }

    @Override
    public Identity<ThirdIndexRecord, Integer> getIdentity() {
        return Keys.IDENTITY_THIRD_INDEX;
    }

    @Override
    public UniqueKey<ThirdIndexRecord> getPrimaryKey() {
        return Keys.KEY_THIRD_INDEX_PRIMARY;
    }

    @Override
    public List<UniqueKey<ThirdIndexRecord>> getKeys() {
        return Arrays.<UniqueKey<ThirdIndexRecord>>asList(Keys.KEY_THIRD_INDEX_PRIMARY);
    }

    @Override
    public List<ForeignKey<ThirdIndexRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ThirdIndexRecord, ?>>asList(Keys.THIRD_INDEX_SECOND_INDEX_ID_FK);
    }

    public SecondIndex secondIndex() {
        return new SecondIndex(this, Keys.THIRD_INDEX_SECOND_INDEX_ID_FK);
    }

    @Override
    public ThirdIndex as(String alias) {
        return new ThirdIndex(DSL.name(alias), this);
    }

    @Override
    public ThirdIndex as(Name alias) {
        return new ThirdIndex(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ThirdIndex rename(String name) {
        return new ThirdIndex(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ThirdIndex rename(Name name) {
        return new ThirdIndex(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
