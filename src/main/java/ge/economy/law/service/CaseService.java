package ge.economy.law.service;


import ge.economy.law.dao.CaseDAO;
import ge.economy.law.dto.CaseDTO;
import ge.economy.law.dto.CourtInstanceHistoryDTO;
import ge.economy.law.dto.StatusDTO;
import ge.economy.law.model.Tables;
import ge.economy.law.model.tables.records.CaseRecord;
import ge.economy.law.request.AddCaseRequest;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CaseRecord record = null;

        if (request.getId() != null) {
            record = caseDAO.getCaseObjectById(request.getId());
        }

        if (record == null) {
            record = dslContext.newRecord(Tables.CASE);
            newRecord = true;
        }
        record.setName(request.getName());
        if (newRecord) {
            record.store();
        } else {
            record.update();
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
