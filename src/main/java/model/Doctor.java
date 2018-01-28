package model;

import program.Hospital;

import java.util.HashMap;
import java.util.Map;

public class Doctor extends Person {

    private String speciality;


    public Doctor(String nin, String name, String surname, String spec) {
        super(nin, name, surname);
        this.speciality = spec;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    private Map<String, Patient> patients = new HashMap<String, Patient>();

    public void addPatient(Patient patient){
        if(Hospital.getInstance().tryGetPatient(patient.nin) != null){
            patients.put(nin, patient);
        }
    }

}
