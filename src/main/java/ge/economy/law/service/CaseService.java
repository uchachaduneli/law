package ge.economy.law.service;


import ge.economy.law.dao.CaseDAO;
import ge.economy.law.dto.CaseDTO;
import ge.economy.law.dto.CourtInstanceHistoryDTO;
import ge.economy.law.dto.StatusDTO;
import ge.economy.law.model.Tables;
import ge.economy.law.model.tables.records.CaseRecord;
import ge.economy.law.model.tables.records.CourtInstanceHistoryRecord;
import ge.economy.law.request.AddCaseRequest;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author ucha
 */
@Service
public class CaseService {

    @Autowired
    private CaseDAO caseDAO;

    @Autowired
    private DSLContext dslContext;

    public HashMap<String, Object> getCases(int start, int limit) {
        new HashMap();
        HashMap<String, Object> resultMap = new HashMap();
        HashMap<String, Object> map = caseDAO.getCases(start, limit);
        List<CaseDTO> items = CaseDTO.translateArray((List) map.get("list"));
        resultMap.put("list", items);
        resultMap.put("size", map.get("size"));
        return resultMap;
    }


    public CaseDTO save(AddCaseRequest request) {
        boolean newRecord = false;
        boolean newInstanceHidtoryRecord = false;
        CaseRecord record = null;
        CourtInstanceHistoryRecord instanceHistoryRecord = null;
        if (request.getCaseId() != null) {
            record = caseDAO.getCaseObjectById(request.getCaseId());
        }

        if (record == null || request.getCourtInstanceId() != record.getCourtInstanceId()) {//ინსტანციის ისტორიაში გადაყრა
            newInstanceHidtoryRecord = true;
        }

        if (record == null) {
            record = dslContext.newRecord(Tables.CASE);
            newRecord = true;
        }

        record.setName(request.getName());
        record.setNumber(request.getNumber());
        record.setJudgeId(request.getJudgeId());
        record.setCaseStartDate(new Date(request.getCaseStartDate().getTime()));
        record.setCaseEndDate(new Date(request.getCaseEndDate().getTime()));
        record.setLitigationSubjectId(request.getLitigationSubjectId());
        record.setLitigationDescription(request.getLitigationDescription());
        record.setEndResultId(request.getEndResultId());
        record.setNote(request.getNote());
        record.setAddUser(request.getAddUser());
        record.setCourtId(request.getCourtId());
        record.setStatusId(request.getStatusId());
        record.setCourtInstanceId(request.getCourtInstanceId());

        if (newRecord) {
            record.store();
        } else {
            record.update();
        }

        if (newInstanceHidtoryRecord) {
            instanceHistoryRecord = dslContext.newRecord(Tables.COURT_INSTANCE_HISTORY);
            instanceHistoryRecord.setCaseId(record.getCaseId());
            instanceHistoryRecord.setCourtInstanceId(request.getCourtInstanceId());
            instanceHistoryRecord.setNote(request.getCourtInstanceNote());
            instanceHistoryRecord.store();
        }

        return CaseDTO.translate(record);
    }


    public List<CourtInstanceHistoryDTO> getInstanceHistory(int id) {
        return CourtInstanceHistoryDTO.translateArray(caseDAO.getInstanceHistory(id));
    }

    public List<StatusDTO> getStatus() {
        return StatusDTO.translateArray(caseDAO.getCaseStatuses());
    }

    public void deleteCase(int id) {
        caseDAO.deleteCase(id);
    }
}
