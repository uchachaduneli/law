package ge.economy.law.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.economy.law.misc.JsonDateSerializeSupport;
import ge.economy.law.model.Tables;
import org.jooq.Record;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourtInstanceHistoryDTO {

    private Integer id;
    private Integer caseId;
    private String note;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Date insertDate;
    private Integer courtInstanceId;
    private String courtInstanceName;


    public static CourtInstanceHistoryDTO translate(Record record) {
        CourtInstanceHistoryDTO dto = new CourtInstanceHistoryDTO();
        dto.setId(record.getValue(Tables.COURT_INSTANCE_HISTORY.ID));
        dto.setCaseId(record.getValue(Tables.COURT_INSTANCE_HISTORY.CASE_ID));
        dto.setNote(record.getValue(Tables.COURT_INSTANCE_HISTORY.NOTE));
        dto.setInsertDate(record.getValue(Tables.COURT_INSTANCE_HISTORY.INSERT_DATE));
        dto.setCourtInstanceId(record.getValue(Tables.COURT_INSTANCE_HISTORY.COURT_INSTANCE_ID));
        if (dto.getCourtInstanceId() != null && record.field(Tables.COURT_INSTANCE.NAME) != null) {
            dto.setCourtInstanceName(record.getValue(Tables.COURT_INSTANCE.NAME));
        }
        return dto;
    }


    public static List<CourtInstanceHistoryDTO> translateArray(List<Record> records) {
        ArrayList<CourtInstanceHistoryDTO> list = new ArrayList<CourtInstanceHistoryDTO>();
        for (Record record : records) {
            list.add(CourtInstanceHistoryDTO.translate(record));
        }
        return list;
    }

    public String getCourtInstanceName() {
        return courtInstanceName;
    }

    public void setCourtInstanceName(String courtInstanceName) {
        this.courtInstanceName = courtInstanceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getCourtInstanceId() {
        return courtInstanceId;
    }

    public void setCourtInstanceId(Integer courtInstanceId) {
        this.courtInstanceId = courtInstanceId;
    }
}
