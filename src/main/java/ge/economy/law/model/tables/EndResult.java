/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables;


import ge.economy.law.model.Keys;
import ge.economy.law.model.Public;
import ge.economy.law.model.tables.records.EndResultRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * საქმის დამთავრების შედეგი
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EndResult extends TableImpl<EndResultRecord> {

	private static final long serialVersionUID = 1009511414;

	/**
	 * The reference instance of <code>public.end_result</code>
	 */
	public static final EndResult END_RESULT = new EndResult();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<EndResultRecord> getRecordType() {
		return EndResultRecord.class;
	}

	/**
	 * The column <code>public.end_result.end_result_id</code>.
	 */
	public final TableField<EndResultRecord, Integer> END_RESULT_ID = createField("end_result_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.end_result.name</code>.
	 */
	public final TableField<EndResultRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * Create a <code>public.end_result</code> table reference
	 */
	public EndResult() {
		this("end_result", null);
	}

	/**
	 * Create an aliased <code>public.end_result</code> table reference
	 */
	public EndResult(String alias) {
		this(alias, END_RESULT);
	}

	private EndResult(String alias, Table<EndResultRecord> aliased) {
		this(alias, aliased, null);
	}

	private EndResult(String alias, Table<EndResultRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "საქმის დამთავრების შედეგი");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<EndResultRecord, Integer> getIdentity() {
		return Keys.IDENTITY_END_RESULT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<EndResultRecord> getPrimaryKey() {
		return Keys.END_RESULT_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<EndResultRecord>> getKeys() {
		return Arrays.<UniqueKey<EndResultRecord>>asList(Keys.END_RESULT_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EndResult as(String alias) {
		return new EndResult(alias, this);
	}

	/**
	 * Rename this table
	 */
	public EndResult rename(String name) {
		return new EndResult(name, null);
	}
}
