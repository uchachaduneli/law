/**
 * This class is generated by jOOQ
 */
package ge.economy.law.model;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.case_case_id_seq</code>
	 */
	public static final Sequence<Integer> CASE_CASE_ID_SEQ = new SequenceImpl<Integer>("case_case_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.court_court_id_seq</code>
	 */
	public static final Sequence<Integer> COURT_COURT_ID_SEQ = new SequenceImpl<Integer>("court_court_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.court_instance_court_instance_id_seq</code>
	 */
	public static final Sequence<Integer> COURT_INSTANCE_COURT_INSTANCE_ID_SEQ = new SequenceImpl<Integer>("court_instance_court_instance_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.court_instance_instance_id_seq</code>
	 */
	public static final Sequence<Integer> COURT_INSTANCE_INSTANCE_ID_SEQ = new SequenceImpl<Integer>("court_instance_instance_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.end_result_end_result_id_seq</code>
	 */
	public static final Sequence<Integer> END_RESULT_END_RESULT_ID_SEQ = new SequenceImpl<Integer>("end_result_end_result_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.judge_judge_id_seq</code>
	 */
	public static final Sequence<Integer> JUDGE_JUDGE_ID_SEQ = new SequenceImpl<Integer>("judge_judge_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.litigation_subject_litigation_subject_seq</code>
	 */
	public static final Sequence<Integer> LITIGATION_SUBJECT_LITIGATION_SUBJECT_SEQ = new SequenceImpl<Integer>("litigation_subject_litigation_subject_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.status_status_id_seq</code>
	 */
	public static final Sequence<Integer> STATUS_STATUS_ID_SEQ = new SequenceImpl<Integer>("status_status_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.user_status_status_id_seq</code>
	 */
	public static final Sequence<Integer> USER_STATUS_STATUS_ID_SEQ = new SequenceImpl<Integer>("user_status_status_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.user_type_type_id_seq</code>
	 */
	public static final Sequence<Integer> USER_TYPE_TYPE_ID_SEQ = new SequenceImpl<Integer>("user_type_type_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

	/**
	 * The sequence <code>public.user_user_id_seq</code>
	 */
	public static final Sequence<Integer> USER_USER_ID_SEQ = new SequenceImpl<Integer>("user_user_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));
}
