/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables;


import ge.economy.law.model.Keys;
import ge.economy.law.model.Public;
import ge.economy.law.model.tables.records.CaseRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * განსახილველი საქმე
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Case extends TableImpl<CaseRecord> {

	private static final long serialVersionUID = -1183616585;

	/**
	 * The reference instance of <code>public.case</code>
	 */
	public static final Case CASE = new Case();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CaseRecord> getRecordType() {
		return CaseRecord.class;
	}

	/**
	 * The column <code>public.case.case_id</code>.
	 */
	public final TableField<CaseRecord, Integer> CASE_ID = createField("case_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.case.name</code>.
	 */
	public final TableField<CaseRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(500).nullable(false), this, "");

	/**
	 * The column <code>public.case.number</code>.
	 */
	public final TableField<CaseRecord, String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>public.case.judge_id</code>.
	 */
	public final TableField<CaseRecord, Integer> JUDGE_ID = createField("judge_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.case.judge_assistant_phone</code>.
	 */
	public final TableField<CaseRecord, String> JUDGE_ASSISTANT_PHONE = createField("judge_assistant_phone", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * The column <code>public.case.case_start_date</code>.
	 */
	public final TableField<CaseRecord, Date> CASE_START_DATE = createField("case_start_date", org.jooq.impl.SQLDataType.DATE, this, "");

	/**
	 * The column <code>public.case.litigation_subject_id</code>.
	 */
	public final TableField<CaseRecord, Integer> LITIGATION_SUBJECT_ID = createField("litigation_subject_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.case.litigation_description</code>.
	 */
	public final TableField<CaseRecord, String> LITIGATION_DESCRIPTION = createField("litigation_description", org.jooq.impl.SQLDataType.VARCHAR.length(1000), this, "");

	/**
	 * The column <code>public.case.end_result_id</code>.
	 */
	public final TableField<CaseRecord, Integer> END_RESULT_ID = createField("end_result_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.case.case_end_date</code>.
	 */
	public final TableField<CaseRecord, Date> CASE_END_DATE = createField("case_end_date", org.jooq.impl.SQLDataType.DATE, this, "");

	/**
	 * The column <code>public.case.note</code>.
	 */
	public final TableField<CaseRecord, String> NOTE = createField("note", org.jooq.impl.SQLDataType.VARCHAR.length(1000), this, "");

	/**
	 * The column <code>public.case.add_user</code>.
	 */
	public final TableField<CaseRecord, String> ADD_USER = createField("add_user", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>public.case.court_id</code>.
	 */
	public final TableField<CaseRecord, Integer> COURT_ID = createField("court_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.case.status_id</code>.
	 */
	public final TableField<CaseRecord, Integer> STATUS_ID = createField("status_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.case.court_instance_id</code>.
	 */
	public final TableField<CaseRecord, Integer> COURT_INSTANCE_ID = createField("court_instance_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.case</code> table reference
	 */
	public Case() {
		this("case", null);
	}

	/**
	 * Create an aliased <code>public.case</code> table reference
	 */
	public Case(String alias) {
		this(alias, CASE);
	}

	private Case(String alias, Table<CaseRecord> aliased) {
		this(alias, aliased, null);
	}

	private Case(String alias, Table<CaseRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "განსახილველი საქმე");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<CaseRecord, Integer> getIdentity() {
		return Keys.IDENTITY_CASE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<CaseRecord> getPrimaryKey() {
		return Keys.CASE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<CaseRecord>> getKeys() {
		return Arrays.<UniqueKey<CaseRecord>>asList(Keys.CASE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<CaseRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<CaseRecord, ?>>asList(Keys.CASE__FK_CASE_TO_JUDGE, Keys.CASE__FK_LITIGATION_SUBJECT_ID, Keys.CASE__FK_CASE_TO_END_RESULT, Keys.CASE__FK_CASE_TO_COURT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Case as(String alias) {
		return new Case(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Case rename(String name) {
		return new Case(name, null);
	}
}
