/*
 * This file is generated by jOOQ.
 */
package com.imjava.dbshow.db.tables;


import com.imjava.dbshow.db.Dbshow;
import com.imjava.dbshow.db.Indexes;
import com.imjava.dbshow.db.Keys;
import com.imjava.dbshow.db.tables.records.FirstIndexRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 一级指标
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FirstIndex extends TableImpl<FirstIndexRecord> {

    private static final long serialVersionUID = 743761649;

    /**
     * The reference instance of <code>dbshow.first_index</code>
     */
    public static final FirstIndex FIRST_INDEX = new FirstIndex();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FirstIndexRecord> getRecordType() {
        return FirstIndexRecord.class;
    }

    /**
     * The column <code>dbshow.first_index.id</code>.
     */
    public final TableField<FirstIndexRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>dbshow.first_index.name</code>.
     */
    public final TableField<FirstIndexRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * Create a <code>dbshow.first_index</code> table reference
     */
    public FirstIndex() {
        this(DSL.name("first_index"), null);
    }

    /**
     * Create an aliased <code>dbshow.first_index</code> table reference
     */
    public FirstIndex(String alias) {
        this(DSL.name(alias), FIRST_INDEX);
    }

    /**
     * Create an aliased <code>dbshow.first_index</code> table reference
     */
    public FirstIndex(Name alias) {
        this(alias, FIRST_INDEX);
    }

    private FirstIndex(Name alias, Table<FirstIndexRecord> aliased) {
        this(alias, aliased, null);
    }

    private FirstIndex(Name alias, Table<FirstIndexRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("一级指标"));
    }

    public <O extends Record> FirstIndex(Table<O> child, ForeignKey<O, FirstIndexRecord> key) {
        super(child, key, FIRST_INDEX);
    }

    @Override
    public Schema getSchema() {
        return Dbshow.DBSHOW;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FIRST_INDEX_PRIMARY);
    }

    @Override
    public Identity<FirstIndexRecord, Integer> getIdentity() {
        return Keys.IDENTITY_FIRST_INDEX;
    }

    @Override
    public UniqueKey<FirstIndexRecord> getPrimaryKey() {
        return Keys.KEY_FIRST_INDEX_PRIMARY;
    }

    @Override
    public List<UniqueKey<FirstIndexRecord>> getKeys() {
        return Arrays.<UniqueKey<FirstIndexRecord>>asList(Keys.KEY_FIRST_INDEX_PRIMARY);
    }

    @Override
    public FirstIndex as(String alias) {
        return new FirstIndex(DSL.name(alias), this);
    }

    @Override
    public FirstIndex as(Name alias) {
        return new FirstIndex(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FirstIndex rename(String name) {
        return new FirstIndex(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FirstIndex rename(Name name) {
        return new FirstIndex(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
