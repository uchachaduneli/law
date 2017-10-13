/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables;


import ge.economy.law.model.Keys;
import ge.economy.law.model.Public;
import ge.economy.law.model.tables.records.CourtInstanceRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;


/**
 * საქმის სასამართლო ინსტანციების ისტორია
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CourtInstance extends TableImpl<CourtInstanceRecord> {

	private static final long serialVersionUID = -1514825496;

	/**
	 * The reference instance of <code>public.court_instance</code>
	 */
	public static final CourtInstance COURT_INSTANCE = new CourtInstance();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CourtInstanceRecord> getRecordType() {
		return CourtInstanceRecord.class;
	}

	/**
	 * The column <code>public.court_instance.court_instance_id</code>.
	 */
	public final TableField<CourtInstanceRecord, Integer> COURT_INSTANCE_ID = createField("court_instance_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.court_instance.case_id</code>.
	 */
	public final TableField<CourtInstanceRecord, Integer> CASE_ID = createField("case_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.court_instance.note</code>.
	 */
	public final TableField<CourtInstanceRecord, String> NOTE = createField("note", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

	/**
	 * The column <code>public.court_instance.insert_date</code>.
	 */
	public final TableField<CourtInstanceRecord, Date> INSERT_DATE = createField("insert_date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

	/**
	 * Create a <code>public.court_instance</code> table reference
	 */
	public CourtInstance() {
		this("court_instance", null);
	}

	/**
	 * Create an aliased <code>public.court_instance</code> table reference
	 */
	public CourtInstance(String alias) {
		this(alias, COURT_INSTANCE);
	}

	private CourtInstance(String alias, Table<CourtInstanceRecord> aliased) {
		this(alias, aliased, null);
	}

	private CourtInstance(String alias, Table<CourtInstanceRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "საქმის სასამართლო ინსტანციების ისტორია");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<CourtInstanceRecord, Integer> getIdentity() {
		return Keys.IDENTITY_COURT_INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<CourtInstanceRecord> getPrimaryKey() {
		return Keys.COURT_INSTANCE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<CourtInstanceRecord>> getKeys() {
		return Arrays.<UniqueKey<CourtInstanceRecord>>asList(Keys.COURT_INSTANCE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CourtInstance as(String alias) {
		return new CourtInstance(alias, this);
	}

	/**
	 * Rename this table
	 */
	public CourtInstance rename(String name) {
		return new CourtInstance(name, null);
	}
}