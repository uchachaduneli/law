/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables.records;


import ge.economy.law.model.tables.User;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Date;


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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record8<Integer, String, String, String, String, Integer, Date, Integer> {

	private static final long serialVersionUID = -1017057753;

	/**
	 * Setter for <code>public.user.user_id</code>.
	 */
	public void setUserId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.user.user_id</code>.
	 */
	public Integer getUserId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.user.firstname</code>.
	 */
	public void setFirstname(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.user.firstname</code>.
	 */
	public String getFirstname() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.user.lastname</code>.
	 */
	public void setLastname(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.user.lastname</code>.
	 */
	public String getLastname() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.user.username</code>.
	 */
	public void setUsername(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.user.username</code>.
	 */
	public String getUsername() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>public.user.password</code>.
	 */
	public void setPassword(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.user.password</code>.
	 */
	public String getPassword() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>public.user.type_id</code>.
	 */
	public void setTypeId(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.user.type_id</code>.
	 */
	public Integer getTypeId() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>public.user.insert_date</code>.
	 */
	public void setInsertDate(Date value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.user.insert_date</code>.
	 */
	public Date getInsertDate() {
		return (Date) getValue(6);
	}

	/**
	 * Setter for <code>public.user.status_id</code>.
	 */
	public void setStatusId(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.user.status_id</code>.
	 */
	public Integer getStatusId() {
		return (Integer) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Integer, Date, Integer> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Integer, Date, Integer> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return User.USER.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return User.USER.FIRSTNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return User.USER.LASTNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return User.USER.USERNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return User.USER.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return User.USER.TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field7() {
		return User.USER.INSERT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return User.USER.STATUS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getFirstname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getLastname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value7() {
		return getInsertDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getStatusId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value1(Integer value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value2(String value) {
		setFirstname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value3(String value) {
		setLastname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value4(String value) {
		setUsername(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value5(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value6(Integer value) {
		setTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value7(Date value) {
		setInsertDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value8(Integer value) {
		setStatusId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6, Date value7, Integer value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserRecord
	 */
	public UserRecord() {
		super(User.USER);
	}

	/**
	 * Create a detached, initialised UserRecord
	 */
	public UserRecord(Integer userId, String firstname, String lastname, String username, String password, Integer typeId, Date insertDate, Integer statusId) {
		super(User.USER);

		setValue(0, userId);
		setValue(1, firstname);
		setValue(2, lastname);
		setValue(3, username);
		setValue(4, password);
		setValue(5, typeId);
		setValue(6, insertDate);
		setValue(7, statusId);
	}
}