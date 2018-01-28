package model;

import java.util.Date;

public abstract class LaboratoryExamination {
    public int examinationID;
    public Date date;

    public LaboratoryExamination(int examinationID, Date date) {
        this.examinationID = examinationID;
        this.date = date;
    }

    public int getExaminationID() {
        return examinationID;
    }

    public void setExaminationID(int examinationID) {
        this.examinationID = examinationID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
