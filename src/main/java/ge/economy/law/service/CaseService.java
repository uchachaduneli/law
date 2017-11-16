package ge.economy.law.service;


import ge.economy.law.dao.CaseDAO;
import ge.economy.law.dto.CaseDTO;
import ge.economy.law.dto.StatusDTO;
import ge.economy.law.dto.UserReportDTO;
import ge.economy.law.model.Tables;
import ge.economy.law.model.tables.records.CaseRecord;
import ge.economy.law.request.AddCaseRequest;
import ge.economy.law.request.SearchCaseRequest;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

    public HashMap<String, Object> getCases(int start, int limit, SearchCaseRequest srchCase) {
        new HashMap();
        HashMap<String, Object> resultMap = new HashMap();
        HashMap<String, Object> map = caseDAO.getCases(start, limit, srchCase);
        List<CaseDTO> items = CaseDTO.translateArray((List) map.get("list"));
        resultMap.put("list", items);
        resultMap.put("size", map.get("size"));
        return resultMap;
    }

    public HashMap<String, Object> getReport(SearchCaseRequest srchCase) {
        new HashMap();
        HashMap<String, Object> resultMap = new HashMap();
        HashMap<String, Object> map = caseDAO.getReport(srchCase);
        List<UserReportDTO> items = UserReportDTO.translateArray((List) map.get("list"));
        resultMap.put("list", items);
        resultMap.put("sum", map.get("sum"));
        return resultMap;
    }


    public CaseDTO save(AddCaseRequest request) {
        boolean newRecord = false;
        boolean newInstanceHidtoryRecord = false;
        CaseRecord record = null;
        if (request.getCaseId() != null) {
            record = caseDAO.getCaseObjectById(request.getCaseId());
        }

        if (record == null) {
            record = dslContext.newRecord(Tables.CASE);
            newRecord = true;
            record.setAddUserId(request.getAddUserId());
            record.setGroupId(new SimpleDateFormat("yyMMddhhmmssMs").format(new java.util.Date()));
        }

        if (!newRecord && request.getCourtInstanceId() != record.getCourtInstanceId()) {//ინსტანციის ისტორიაში გადაყრა
            newInstanceHidtoryRecord = true;
            record = dslContext.newRecord(Tables.CASE);
            record.setAddUserId(request.getAddUserId());
        }

        if (!newRecord) {
            record.setGroupId(request.getGroupId());
        }
        record.setName(request.getName());
        record.setNumber(request.getNumber());
        record.setLitigationPrice(request.getLitigationPrice());
        record.setJudgeId(request.getJudgeId());
        record.setCaseStartDate(new Date(request.getCaseStartDate().getTime()));
        if (request.getCaseEndDate() != null) {
            record.setCaseEndDate(new Date(request.getCaseEndDate().getTime()));
        }
        record.setLitigationSubjectId(request.getLitigationSubjectId());
        record.setLitigationDescription(request.getLitigationDescription());
        record.setEndResultId(request.getEndResultId());
        record.setNote(request.getNote());
        record.setCourtId(request.getCourtId());
        record.setStatusId(request.getStatusId());
        record.setMinistryStatus(request.getMinistryStatus());
        record.setBoardId(request.getBoardId());
        record.setThirdPersons(request.getThirdPersons());
        record.setCourtInstanceId(request.getCourtInstanceId());

        if (newRecord || newInstanceHidtoryRecord) {// თუ ახალ ინსტანციაზე გადავიდა ახალი ჩანაწერი კეთდება ცხრილში დატაც მიყვება შეიძლება შეცვლილი
            record.store();
        } else {
            record.update();
        }

        return CaseDTO.translate(caseDAO.getWholeCaseObjectById(record.getCaseId()));
    }

    public List<StatusDTO> getStatus() {
        return StatusDTO.translateArray(caseDAO.getCaseStatuses());
    }

    public void deleteCase(int id) {
        caseDAO.deleteCase(id);
    }

    public List<CaseDTO> getInstanceHistory(int id, String number) {
        return CaseDTO.translateArray(caseDAO.getInstanceHistory(id, number));
    }
}
