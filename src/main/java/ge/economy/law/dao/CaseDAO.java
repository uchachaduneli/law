package ge.economy.law.dao;

import ge.economy.law.model.Tables;
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
        return dslContext.
                select()
                .from(Tables.COURT_INSTANCE_HISTORY)
                .where(Tables.COURT_INSTANCE_HISTORY.CASE_ID.eq(itemId))
                .fetch();
    }

    public void deleteCase(int itemId) {
        dslContext.deleteFrom(Tables.CASE).where(Tables.CASE.CASE_ID.eq(itemId)).execute();
    }

}
