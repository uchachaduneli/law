/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables;


import ge.economy.law.model.Keys;
import ge.economy.law.model.Public;
import ge.economy.law.model.tables.records.LitigationSubjectRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * დავის საგნები
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LitigationSubject extends TableImpl<LitigationSubjectRecord> {

	private static final long serialVersionUID = -1219136199;

	/**
	 * The reference instance of <code>public.litigation_subject</code>
	 */
	public static final LitigationSubject LITIGATION_SUBJECT = new LitigationSubject();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<LitigationSubjectRecord> getRecordType() {
		return LitigationSubjectRecord.class;
	}

	/**
	 * The column <code>public.litigation_subject.litigation_subject_id</code>.
	 */
	public final TableField<LitigationSubjectRecord, Integer> LITIGATION_SUBJECT_ID = createField("litigation_subject_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.litigation_subject.name</code>.
	 */
	public final TableField<LitigationSubjectRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(200).nullable(false), this, "");

	/**
	 * Create a <code>public.litigation_subject</code> table reference
	 */
	public LitigationSubject() {
		this("litigation_subject", null);
	}

	/**
	 * Create an aliased <code>public.litigation_subject</code> table reference
	 */
	public LitigationSubject(String alias) {
		this(alias, LITIGATION_SUBJECT);
	}

	private LitigationSubject(String alias, Table<LitigationSubjectRecord> aliased) {
		this(alias, aliased, null);
	}

	private LitigationSubject(String alias, Table<LitigationSubjectRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "დავის საგნები");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<LitigationSubjectRecord, Integer> getIdentity() {
		return Keys.IDENTITY_LITIGATION_SUBJECT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<LitigationSubjectRecord> getPrimaryKey() {
		return Keys.LITIGATION_SUBJECT_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<LitigationSubjectRecord>> getKeys() {
		return Arrays.<UniqueKey<LitigationSubjectRecord>>asList(Keys.LITIGATION_SUBJECT_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LitigationSubject as(String alias) {
		return new LitigationSubject(alias, this);
	}

	/**
	 * Rename this table
	 */
	public LitigationSubject rename(String name) {
		return new LitigationSubject(name, null);
	}
}
