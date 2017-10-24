package ge.economy.law.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.economy.law.misc.JsonDateSerializeSupport;
import ge.economy.law.model.Tables;
import org.jooq.Record;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseDTO {
    private Integer caseId;
    private String name;
    private String number;
    private Integer judgeId;
    private String judgeAssistantPhone;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Date caseStartDate;
    private Integer litigationSubjectId;
    private String litigationDescription;
    private Integer endResultId;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Date caseEndDate;
    private String note;
    private String addUser;
    private Integer courtId;
    private Integer statusId;

    public static CaseDTO translate(Record record) {
        CaseDTO dto = new CaseDTO();
        dto.setCaseId(record.getValue(Tables.CASE.CASE_ID));
        dto.setName(record.getValue(Tables.CASE.NAME));
        dto.setNumber(record.getValue(Tables.CASE.NUMBER));
        dto.setJudgeId(record.getValue(Tables.CASE.JUDGE_ID));
        dto.setJudgeAssistantPhone(record.getValue(Tables.CASE.JUDGE_ASSISTANT_PHONE));
        dto.setCaseStartDate(record.getValue(Tables.CASE.CASE_START_DATE));
        dto.setLitigationSubjectId(record.getValue(Tables.CASE.LITIGATION_SUBJECT_ID));
        dto.setLitigationDescription(record.getValue(Tables.CASE.LITIGATION_DESCRIPTION));
        dto.setEndResultId(record.getValue(Tables.CASE.END_RESULT_ID));
        dto.setCaseEndDate(record.getValue(Tables.CASE.CASE_END_DATE));
        dto.setNote(record.getValue(Tables.CASE.NOTE));
        dto.setAddUser(record.getValue(Tables.CASE.ADD_USER));
        dto.setCourtId(record.getValue(Tables.CASE.COURT_ID));
        dto.setStatusId(record.getValue(Tables.CASE.STATUS_ID));
        return dto;
    }


    public static List<CaseDTO> translateArray(List<Record> records) {
        ArrayList<CaseDTO> list = new ArrayList<CaseDTO>();
        for (Record record : records) {
            list.add(CaseDTO.translate(record));
        }
        return list;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgeAssistantPhone() {
        return judgeAssistantPhone;
    }

    public void setJudgeAssistantPhone(String judgeAssistantPhone) {
        this.judgeAssistantPhone = judgeAssistantPhone;
    }

    public Date getCaseStartDate() {
        return caseStartDate;
    }

    public void setCaseStartDate(Date caseStartDate) {
        this.caseStartDate = caseStartDate;
    }

    public Integer getLitigationSubjectId() {
        return litigationSubjectId;
    }

    public void setLitigationSubjectId(Integer litigationSubjectId) {
        this.litigationSubjectId = litigationSubjectId;
    }

    public String getLitigationDescription() {
        return litigationDescription;
    }

    public void setLitigationDescription(String litigationDescription) {
        this.litigationDescription = litigationDescription;
    }

    public Integer getEndResultId() {
        return endResultId;
    }

    public void setEndResultId(Integer endResultId) {
        this.endResultId = endResultId;
    }

    public Date getCaseEndDate() {
        return caseEndDate;
    }

    public void setCaseEndDate(Date caseEndDate) {
        this.caseEndDate = caseEndDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
