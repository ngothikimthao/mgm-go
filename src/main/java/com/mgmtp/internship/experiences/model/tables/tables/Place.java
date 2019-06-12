/*
 * This file is generated by jOOQ.
 */
package com.mgmtp.internship.experiences.model.tables.tables;


import com.mgmtp.internship.experiences.model.tables.Indexes;
import com.mgmtp.internship.experiences.model.tables.Keys;
import com.mgmtp.internship.experiences.model.tables.Public;
import com.mgmtp.internship.experiences.model.tables.tables.records.PlaceRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * place table
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Place extends TableImpl<PlaceRecord> {

    private static final long serialVersionUID = 622947298;

    /**
     * The reference instance of <code>public.place</code>
     */
    public static final Place PLACE = new Place();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlaceRecord> getRecordType() {
        return PlaceRecord.class;
    }

    /**
     * The column <code>public.place.id</code>.
     */
    public final TableField<PlaceRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('place_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.place.title</code>.
     */
    public final TableField<PlaceRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>public.place</code> table reference
     */
    public Place() {
        this(DSL.name("place"), null);
    }

    /**
     * Create an aliased <code>public.place</code> table reference
     */
    public Place(String alias) {
        this(DSL.name(alias), PLACE);
    }

    /**
     * Create an aliased <code>public.place</code> table reference
     */
    public Place(Name alias) {
        this(alias, PLACE);
    }

    private Place(Name alias, Table<PlaceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Place(Name alias, Table<PlaceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("place table"));
    }

    public <O extends Record> Place(Table<O> child, ForeignKey<O, PlaceRecord> key) {
        super(child, key, PLACE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PK_PLACE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PlaceRecord, Long> getIdentity() {
        return Keys.IDENTITY_PLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PlaceRecord> getPrimaryKey() {
        return Keys.PK_PLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PlaceRecord>> getKeys() {
        return Arrays.<UniqueKey<PlaceRecord>>asList(Keys.PK_PLACE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Place as(String alias) {
        return new Place(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Place as(Name alias) {
        return new Place(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Place rename(String name) {
        return new Place(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Place rename(Name name) {
        return new Place(name, null);
    }
}
