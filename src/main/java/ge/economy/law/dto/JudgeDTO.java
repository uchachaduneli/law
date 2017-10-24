package ge.economy.law.dto;

import ge.economy.law.model.Tables;
import org.jooq.Record;

import java.util.ArrayList;
import java.util.List;

public class JudgeDTO {

    private int judgeId;
    private String name;


    public static JudgeDTO translate(Record record) {
        JudgeDTO dto = new JudgeDTO();
        dto.setJudgeId(record.getValue(Tables.JUDGE.JUDGE_ID));
        dto.setName(record.getValue(Tables.JUDGE.NAME));
        return dto;
    }


    public static List<JudgeDTO> translateArray(List<Record> records) {
        ArrayList<JudgeDTO> list = new ArrayList<JudgeDTO>();
        for (Record record : records) {
            list.add(JudgeDTO.translate(record));
        }
        return list;
    }

    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
