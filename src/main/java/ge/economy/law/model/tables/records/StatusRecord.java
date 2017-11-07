/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables.records;


import ge.economy.law.model.tables.Status;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StatusRecord extends UpdatableRecordImpl<StatusRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 318052812;

	/**
	 * Setter for <code>public.status.status_id</code>.
	 */
	public void setStatusId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.status.status_id</code>.
	 */
	public Integer getStatusId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.status.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.status.name</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Status.STATUS.STATUS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Status.STATUS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getStatusId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusRecord value1(Integer value) {
		setStatusId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusRecord values(Integer value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached StatusRecord
	 */
	public StatusRecord() {
		super(Status.STATUS);
	}

	/**
	 * Create a detached, initialised StatusRecord
	 */
	public StatusRecord(Integer statusId, String name) {
		super(Status.STATUS);

		setValue(0, statusId);
		setValue(1, name);
	}
}
