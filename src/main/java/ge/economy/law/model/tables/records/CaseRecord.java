/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model.tables.records;


import ge.economy.law.model.tables.Case;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record19;
import org.jooq.Row19;
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
public class CaseRecord extends UpdatableRecordImpl<CaseRecord> implements Record19<Integer, String, String, Integer, Date, Integer, String, Integer, Date, String, Integer, Integer, Integer, Integer, Double, String, Integer, String, Integer> {

    private static final long serialVersionUID = 201495434;

	/**
	 * Setter for <code>public.case.case_id</code>.
	 */
	public void setCaseId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.case.case_id</code>.
	 */
	public Integer getCaseId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.case.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.case.name</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.case.number</code>.
	 */
	public void setNumber(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.case.number</code>.
	 */
	public String getNumber() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.case.judge_id</code>.
	 */
	public void setJudgeId(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.case.judge_id</code>.
	 */
	public Integer getJudgeId() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>public.case.case_start_date</code>.
	 */
	public void setCaseStartDate(Date value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.case.case_start_date</code>.
	 */
	public Date getCaseStartDate() {
		return (Date) getValue(4);
	}

	/**
	 * Setter for <code>public.case.litigation_subject_id</code>.
	 */
	public void setLitigationSubjectId(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.case.litigation_subject_id</code>.
	 */
	public Integer getLitigationSubjectId() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>public.case.litigation_description</code>.
	 */
	public void setLitigationDescription(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.case.litigation_description</code>.
	 */
	public String getLitigationDescription() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>public.case.end_result_id</code>.
	 */
	public void setEndResultId(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.case.end_result_id</code>.
	 */
	public Integer getEndResultId() {
		return (Integer) getValue(7);
	}

	/**
	 * Setter for <code>public.case.case_end_date</code>.
	 */
	public void setCaseEndDate(Date value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.case.case_end_date</code>.
	 */
	public Date getCaseEndDate() {
		return (Date) getValue(8);
	}

	/**
	 * Setter for <code>public.case.note</code>.
	 */
	public void setNote(String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.case.note</code>.
	 */
	public String getNote() {
		return (String) getValue(9);
	}

	/**
	 * Setter for <code>public.case.court_id</code>.
	 */
	public void setCourtId(Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>public.case.court_id</code>.
	 */
	public Integer getCourtId() {
		return (Integer) getValue(10);
	}

	/**
	 * Setter for <code>public.case.status_id</code>.
	 */
	public void setStatusId(Integer value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>public.case.status_id</code>.
	 */
	public Integer getStatusId() {
		return (Integer) getValue(11);
	}

	/**
	 * Setter for <code>public.case.court_instance_id</code>.
	 */
	public void setCourtInstanceId(Integer value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>public.case.court_instance_id</code>.
	 */
	public Integer getCourtInstanceId() {
		return (Integer) getValue(12);
	}

	/**
	 * Setter for <code>public.case.add_user_id</code>.
	 */
	public void setAddUserId(Integer value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>public.case.add_user_id</code>.
	 */
	public Integer getAddUserId() {
		return (Integer) getValue(13);
	}

	/**
	 * Setter for <code>public.case.litigation_price</code>.
	 */
	public void setLitigationPrice(Double value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>public.case.litigation_price</code>.
	 */
	public Double getLitigationPrice() {
		return (Double) getValue(14);
	}

	/**
	 * Setter for <code>public.case.group_id</code>.
	 */
	public void setGroupId(String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>public.case.group_id</code>.
	 */
	public String getGroupId() {
		return (String) getValue(15);
	}

    /**
     * Setter for <code>public.case.board_id</code>.
     */
    public void setBoardId(Integer value) {
        setValue(16, value);
    }

    /**
     * Getter for <code>public.case.board_id</code>.
     */
    public Integer getBoardId() {
        return (Integer) getValue(16);
    }

    /**
     * Setter for <code>public.case.third_persons</code>.
     */
    public void setThirdPersons(String value) {
        setValue(17, value);
    }

    /**
     * Getter for <code>public.case.third_persons</code>.
     */
    public String getThirdPersons() {
        return (String) getValue(17);
    }

    /**
     * Setter for <code>public.case.ministry_status</code>.
     */
    public void setMinistryStatus(Integer value) {
        setValue(18, value);
    }

    /**
     * Getter for <code>public.case.ministry_status</code>.
     */
    public Integer getMinistryStatus() {
        return (Integer) getValue(18);
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
    // Record19 type implementation
	// -------------------------------------------------------------------------

	/**
     * {@inheritDoc}
     */
    @Override
    public Row19<Integer, String, String, Integer, Date, Integer, String, Integer, Date, String, Integer, Integer, Integer, Integer, Double, String, Integer, String, Integer> fieldsRow() {
        return (Row19) super.fieldsRow();
	}

	/**
     * {@inheritDoc}
     */
    @Override
    public Row19<Integer, String, String, Integer, Date, Integer, String, Integer, Date, String, Integer, Integer, Integer, Integer, Double, String, Integer, String, Integer> valuesRow() {
        return (Row19) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Case.CASE.CASE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Case.CASE.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Case.CASE.NUMBER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Case.CASE.JUDGE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field5() {
		return Case.CASE.CASE_START_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return Case.CASE.LITIGATION_SUBJECT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return Case.CASE.LITIGATION_DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return Case.CASE.END_RESULT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field9() {
		return Case.CASE.CASE_END_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field10() {
		return Case.CASE.NOTE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field11() {
		return Case.CASE.COURT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field12() {
		return Case.CASE.STATUS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field13() {
		return Case.CASE.COURT_INSTANCE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field14() {
		return Case.CASE.ADD_USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field15() {
		return Case.CASE.LITIGATION_PRICE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    public Field<String> field16() {
        return Case.CASE.GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return Case.CASE.BOARD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return Case.CASE.THIRD_PERSONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field19() {
        return Case.CASE.MINISTRY_STATUS;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getCaseId();
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
	public String value3() {
		return getNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getJudgeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value5() {
		return getCaseStartDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getLitigationSubjectId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getLitigationDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getEndResultId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value9() {
		return getCaseEndDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value10() {
		return getNote();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value11() {
		return getCourtId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value12() {
		return getStatusId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value13() {
		return getCourtInstanceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value14() {
		return getAddUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value15() {
		return getLitigationPrice();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    public String value16() {
        return getGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getBoardId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getThirdPersons();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value19() {
        return getMinistryStatus();
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value1(Integer value) {
		setCaseId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value3(String value) {
		setNumber(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value4(Integer value) {
		setJudgeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value5(Date value) {
		setCaseStartDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value6(Integer value) {
		setLitigationSubjectId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value7(String value) {
		setLitigationDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value8(Integer value) {
		setEndResultId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value9(Date value) {
		setCaseEndDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value10(String value) {
		setNote(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value11(Integer value) {
		setCourtId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value12(Integer value) {
		setStatusId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value13(Integer value) {
		setCourtInstanceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value14(Integer value) {
		setAddUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value15(Double value) {
		setLitigationPrice(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaseRecord value16(String value) {
		setGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseRecord value17(Integer value) {
        setBoardId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseRecord value18(String value) {
        setThirdPersons(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseRecord value19(Integer value) {
        setMinistryStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseRecord values(Integer value1, String value2, String value3, Integer value4, Date value5, Integer value6, String value7, Integer value8, Date value9, String value10, Integer value11, Integer value12, Integer value13, Integer value14, Double value15, String value16, Integer value17, String value18, Integer value19) {
        value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
		value16(value16);
        value17(value17);
		value18(value18);
		value19(value19);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CaseRecord
	 */
	public CaseRecord() {
        super(Case.CASE);
    }

    /**
     * Create a detached, initialised CaseRecord
     */
    public CaseRecord(Integer caseId, String name, String number, Integer judgeId, Date caseStartDate, Integer litigationSubjectId, String litigationDescription, Integer endResultId, Date caseEndDate, String note, Integer courtId, Integer statusId, Integer courtInstanceId, Integer addUserId, Double litigationPrice, String groupId, Integer boardId, String thirdPersons, Integer ministryStatus) {
        super(Case.CASE);

		setValue(0, caseId);
		setValue(1, name);
		setValue(2, number);
		setValue(3, judgeId);
		setValue(4, caseStartDate);
		setValue(5, litigationSubjectId);
		setValue(6, litigationDescription);
		setValue(7, endResultId);
		setValue(8, caseEndDate);
		setValue(9, note);
		setValue(10, courtId);
		setValue(11, statusId);
		setValue(12, courtInstanceId);
        setValue(13, addUserId);
        setValue(14, litigationPrice);
        setValue(15, groupId);
        setValue(16, boardId);
		setValue(17, thirdPersons);
		setValue(18, ministryStatus);
	}
}
