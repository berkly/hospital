package model;

import java.util.Date;

public class BloodPressure extends LaboratoryExamination{
    private int upperValue;
    private int lowerValue;
    private int pulse;
    public BloodPressure(int exam, Date date, int upperValue, int lowerValue, int pulse) {
        super(exam, date);
        this.upperValue = upperValue;
        this.lowerValue = lowerValue;
        this.pulse = pulse;
    }

    public BloodPressure(int exam, Date date) {
        super(exam, date);
    }

    public int getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(int upperValue) {
        this.upperValue = upperValue;
    }

    public int getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(int lowerValue) {
        this.lowerValue = lowerValue;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
