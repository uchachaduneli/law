package ge.economy.law.service;


import ge.economy.law.dao.CaseDAO;
import ge.economy.law.dto.CaseDTO;
import ge.economy.law.dto.CourtInstanceHistoryDTO;
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

    //    public CourtDTO save(AddKeyValueRequest request) {
//        boolean newRecord = false;
//        CourtRecord record = null;
//
//        if (request.getId() != null) {
//            record = utilDAO.getCourtObjectById(request.getId());
//        }
//
//        if (record == null) {
//            record = dslContext.newRecord(Tables.COURT);
//            newRecord = true;
//        }
//        record.setName(request.getName());
//        if (newRecord) {
//            record.store();
//        } else {
//            record.update();
//        }
//        return CourtDTO.translate(record);
//    }
//
//    public List<CourtDTO> getCourts() {
//        return CourtDTO.translateArray(utilDAO.getCourts());
//    }
//
//

    public List<CourtInstanceHistoryDTO> getInstanceHistory(int id) {
        return CourtInstanceHistoryDTO.translateArray(caseDAO.getInstanceHistory(id));
    }

    public void deleteCase(int id) {
        caseDAO.deleteCase(id);
    }
}
