/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables;


import ge.economy.law.model.Keys;
import ge.economy.law.model.Public;
import ge.economy.law.model.tables.records.StatusRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * საქმის სტატუსი
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Status extends TableImpl<StatusRecord> {

	private static final long serialVersionUID = -928044769;

	/**
	 * The reference instance of <code>public.status</code>
	 */
	public static final Status STATUS = new Status();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StatusRecord> getRecordType() {
		return StatusRecord.class;
	}

	/**
	 * The column <code>public.status.status_id</code>.
	 */
	public final TableField<StatusRecord, Integer> STATUS_ID = createField("status_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.status.name</code>.
	 */
	public final TableField<StatusRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * Create a <code>public.status</code> table reference
	 */
	public Status() {
		this("status", null);
	}

	/**
	 * Create an aliased <code>public.status</code> table reference
	 */
	public Status(String alias) {
		this(alias, STATUS);
	}

	private Status(String alias, Table<StatusRecord> aliased) {
		this(alias, aliased, null);
	}

	private Status(String alias, Table<StatusRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "საქმის სტატუსი");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<StatusRecord, Integer> getIdentity() {
		return Keys.IDENTITY_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<StatusRecord> getPrimaryKey() {
		return Keys.STATUS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<StatusRecord>> getKeys() {
		return Arrays.<UniqueKey<StatusRecord>>asList(Keys.STATUS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Status as(String alias) {
		return new Status(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Status rename(String name) {
		return new Status(name, null);
	}
}
