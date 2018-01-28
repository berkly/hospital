package model;

import java.util.Date;

public class BloodSugarLevel extends LaboratoryExamination{

    private double value;
    private Date lastMealTime;

    public BloodSugarLevel(int exam, Date date, double value, Date last) {
        super(exam, date);
        this.value = value;
        this.lastMealTime = last;
    }

    public BloodSugarLevel(int exam, Date date) {
        super(exam, date);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getLastMealTime() {
        return lastMealTime;
    }

    public void setLastMealTime(Date lastMealTime) {
        this.lastMealTime = lastMealTime;
    }
}
