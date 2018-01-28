package model;

import org.apache.log4j.Logger;
import program.Hospital;

public class Patient extends Person{

    static Logger log = Logger.getLogger(Hospital.class);

    public int medicalRecordNumber;

    public Patient(String nin, String name, String surname,int medRecNum) {
        super(nin, name, surname);
        this.medicalRecordNumber = medRecNum;
    }

    public int getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(int medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    private Doctor assign;

    public void assignDoctor(Doctor doc){
        if (Hospital.getInstance().tryGetDoctor(doc.nin) != null){
            assign = doc;
            log.info("Patient is assigned to " + doc.getName() + " " + doc.getSurname());
        } else {
            log.info("Doctor" + doc.getName() + "" + doc.getSurname() + " doesn't exists!");
        }
    }

}
