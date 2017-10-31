package ge.economy.law.dao;

import ge.economy.law.model.Tables;
import ge.economy.law.model.tables.records.CaseRecord;
import org.jooq.Record;
import org.jooq.SelectOnConditionStep;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ME.
 */

@Repository
public class CaseDAO extends AbstractDAO {

    public HashMap<String, Object> getCases(int start, int limit) {
        SelectOnConditionStep<Record> selectConditionStep =
                dslContext.select()
                        .from(Tables.CASE)
                        .join(Tables.JUDGE)
                        .on(Tables.CASE.JUDGE_ID.eq(Tables.JUDGE.JUDGE_ID))
                        .join(Tables.LITIGATION_SUBJECT)
                        .on(Tables.CASE.LITIGATION_SUBJECT_ID.eq(Tables.LITIGATION_SUBJECT.LITIGATION_SUBJECT_ID))
                        .join(Tables.END_RESULT)
                        .on(Tables.CASE.END_RESULT_ID.eq(Tables.END_RESULT.END_RESULT_ID))
                        .join(Tables.COURT)
                        .on(Tables.CASE.COURT_ID.eq(Tables.COURT.COURT_ID))
                        .join(Tables.USER)
                        .on(Tables.CASE.ADD_USER_ID.eq(Tables.USER.USER_ID))
                        .join(Tables.STATUS)
                        .on(Tables.CASE.STATUS_ID.eq(Tables.STATUS.STATUS_ID));

        selectConditionStep.where();
        SelectOnConditionStep<Record> selectConditionStepSize = selectConditionStep;
        int recordSize = selectConditionStepSize.fetch().size();
        selectConditionStep.orderBy(Tables.CASE.CASE_ID.desc()).limit(limit).offset(start);

        HashMap<String, Object> map = new HashMap();
        map.put("list", selectConditionStep.fetch());
        map.put("size", recordSize);
        return map;
    }

    public List<Record> getInstanceHistory(int itemId) {
        return null;
//        return dslContext.
//                select()
//                .from(Tables.COURT_INSTANCE_HISTORY)
//                .join(Tables.COURT_INSTANCE)
//                .on(Tables.COURT_INSTANCE_HISTORY.COURT_INSTANCE_ID.eq(Tables.COURT_INSTANCE.INSTANCE_ID))
//                .where(Tables.COURT_INSTANCE_HISTORY.CASE_ID.eq(itemId))
//                .fetch();
    }

    public List<Record> getCaseStatuses() {
        return dslContext.
                select().
                from(Tables.STATUS).
                fetch();
    }

    public void deleteCase(int itemId) {
        dslContext.deleteFrom(Tables.CASE).where(Tables.CASE.CASE_ID.eq(itemId)).execute();
    }

    public CaseRecord getCaseObjectById(int id) {
        return dslContext.fetchOne(Tables.CASE, Tables.CASE.CASE_ID.eq(id));
    }

    public Record getWholeCaseObjectById(int id) {

        return dslContext.select()
                .from(Tables.CASE)
                .join(Tables.JUDGE)
                .on(Tables.CASE.JUDGE_ID.eq(Tables.JUDGE.JUDGE_ID))
                .join(Tables.LITIGATION_SUBJECT)
                .on(Tables.CASE.LITIGATION_SUBJECT_ID.eq(Tables.LITIGATION_SUBJECT.LITIGATION_SUBJECT_ID))
                .join(Tables.END_RESULT)
                .on(Tables.CASE.END_RESULT_ID.eq(Tables.END_RESULT.END_RESULT_ID))
                .join(Tables.COURT)
                .on(Tables.CASE.COURT_ID.eq(Tables.COURT.COURT_ID))
                .join(Tables.USER)
                .on(Tables.CASE.ADD_USER_ID.eq(Tables.USER.USER_ID))
                .join(Tables.STATUS)
                .on(Tables.CASE.STATUS_ID.eq(Tables.STATUS.STATUS_ID))
                .where(Tables.CASE.CASE_ID.eq(id))
                .fetchOne();
    }

}
