/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.Keys;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.LinkInfo;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.records.StackoverflowUpdatesRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StackoverflowUpdates extends TableImpl<StackoverflowUpdatesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>LINK_INFO.STACKOVERFLOW_UPDATES</code>
     */
    public static final StackoverflowUpdates STACKOVERFLOW_UPDATES = new StackoverflowUpdates();

    /**
     * The class holding records for this type
     */
    @Override
    @NotNull
    public Class<StackoverflowUpdatesRecord> getRecordType() {
        return StackoverflowUpdatesRecord.class;
    }

    /**
     * The column <code>LINK_INFO.STACKOVERFLOW_UPDATES.ID</code>.
     */
    public final TableField<StackoverflowUpdatesRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>LINK_INFO.STACKOVERFLOW_UPDATES.IS_ANSWERED</code>.
     */
    public final TableField<StackoverflowUpdatesRecord, Boolean> IS_ANSWERED = createField(DSL.name("IS_ANSWERED"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("FALSE"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>LINK_INFO.STACKOVERFLOW_UPDATES.ANSWER_COUNT</code>.
     */
    public final TableField<StackoverflowUpdatesRecord, Integer> ANSWER_COUNT = createField(DSL.name("ANSWER_COUNT"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field(DSL.raw("0"), SQLDataType.INTEGER)), this, "");

    private StackoverflowUpdates(Name alias, Table<StackoverflowUpdatesRecord> aliased) {
        this(alias, aliased, null);
    }

    private StackoverflowUpdates(Name alias, Table<StackoverflowUpdatesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>LINK_INFO.STACKOVERFLOW_UPDATES</code> table
     * reference
     */
    public StackoverflowUpdates(String alias) {
        this(DSL.name(alias), STACKOVERFLOW_UPDATES);
    }

    /**
     * Create an aliased <code>LINK_INFO.STACKOVERFLOW_UPDATES</code> table
     * reference
     */
    public StackoverflowUpdates(Name alias) {
        this(alias, STACKOVERFLOW_UPDATES);
    }

    /**
     * Create a <code>LINK_INFO.STACKOVERFLOW_UPDATES</code> table reference
     */
    public StackoverflowUpdates() {
        this(DSL.name("STACKOVERFLOW_UPDATES"), null);
    }

    public <O extends Record> StackoverflowUpdates(Table<O> child, ForeignKey<O, StackoverflowUpdatesRecord> key) {
        super(child, key, STACKOVERFLOW_UPDATES);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : LinkInfo.LINK_INFO;
    }

    @Override
    @NotNull
    public UniqueKey<StackoverflowUpdatesRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_3;
    }

    @Override
    @NotNull
    public List<ForeignKey<StackoverflowUpdatesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_33);
    }

    private transient Link _link;

    /**
     * Get the implicit join path to the <code>LINK_INFO.LINK</code> table.
     */
    public Link link() {
        if (_link == null)
            _link = new Link(this, Keys.CONSTRAINT_33);

        return _link;
    }

    @Override
    @NotNull
    public StackoverflowUpdates as(String alias) {
        return new StackoverflowUpdates(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public StackoverflowUpdates as(Name alias) {
        return new StackoverflowUpdates(alias, this);
    }

    @Override
    @NotNull
    public StackoverflowUpdates as(Table<?> alias) {
        return new StackoverflowUpdates(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public StackoverflowUpdates rename(String name) {
        return new StackoverflowUpdates(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public StackoverflowUpdates rename(Name name) {
        return new StackoverflowUpdates(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public StackoverflowUpdates rename(Table<?> name) {
        return new StackoverflowUpdates(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row3<Long, Boolean, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super Boolean, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super Boolean, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
