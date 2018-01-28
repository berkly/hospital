package program;

import model.*;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hospital {

    static Logger log = Logger.getLogger(Hospital.class);

    public Hospital() {
    }

    private static Hospital instance;
    public static Hospital getInstance(){
        if (instance == null){
            instance = new Hospital();
        }
        return instance;
    }

    private Map<String, Person> persons = new HashMap<String, Person>();

    private Person tryGetPerson(String nin){
        return persons.get(nin);
    }

    public Doctor tryGetDoctor(String nin){
        Doctor doc;
        doc = (Doctor)tryGetPerson(nin);
        return doc;
    }

    public Patient tryGetPatient(String nin){
        Patient patient;
        patient = (Patient)tryGetPerson(nin);
        return patient;
    }

    public void createDoctor(String nin, String name, String surname, String spec){
        if (tryGetDoctor(nin) ==null && !persons.containsKey(nin)){
            Doctor doctor = new Doctor(nin, name, surname, spec);
            persons.put(nin, doctor);
            log.info("Doctor " + name + " " + surname + " with speciality " + spec + " is created!" );
        } else {
            log.info("Doctor " + name + " " + surname + " already exists!");
        }
    }

    public void createPatient(String nin, String name, String surname, int medRecNum){
        if (tryGetPatient(nin) ==null && !persons.containsKey(nin)){
            Patient patient = new Patient(nin, name, surname, medRecNum);
            persons.put(nin, patient);
            log.info("Patient " + name + " " + surname + " with medical record " + medRecNum + " is created!" );
        } else {
            log.info("Patient " + name + " " + surname + " already exists!");
        }
    }

    public void assignDoctorToPatient(Doctor doctor, Patient patient){
        patient.assignDoctor(doctor);
    }

    private Map<Integer, PatientDoctorExamination> examinations = new HashMap<Integer, PatientDoctorExamination>();

    public enum laboratoryExaminations {
        bloodPressure,
        bloodSugarLevel,
    }

    private int examID;

    public int scheduleExamination(Doctor doctor, Patient patient, Date date, laboratoryExaminations examLab){
        LaboratoryExamination examination = null;
        switch (examLab){
            case bloodPressure:
                examination = new BloodPressure(examID, date);
                break;
            case bloodSugarLevel:
                examination = new BloodSugarLevel(examID, date);
                break;
        }
        examinations.put(examID, new PatientDoctorExamination(doctor,patient,examination));
        examID++;
        return examination.examinationID;
    }

    public void FillBloodSugarLevelExamination(int examinationID, double value, Date date) {
        PatientDoctorExamination patientDoctorExamination = null;

        patientDoctorExamination = examinations.get(examinationID);
        if (patientDoctorExamination != null) {
            if (patientDoctorExamination.getLabExam() instanceof BloodSugarLevel) {
                BloodSugarLevel bloodSugarLevel = (BloodSugarLevel) patientDoctorExamination.getLabExam();
                bloodSugarLevel.setValue(value);
                bloodSugarLevel.setLastMealTime(date);

                log.info("Examination is successfully done! \n" +
                        "==========\n" +
                        "value: " + value +
                        "\nlast meal time: " + date);
            } else
                log.info("Selected examination isn't for blood sugar level!");
            } else {
                log.info("Selected examination doesn't exist!");
        }
    }

    public void FillBloodPressureExamination(int examinationID, int upperValue, int lowerValue, int pulse){
        PatientDoctorExamination patientDoctorExamination = null;
        patientDoctorExamination = examinations.get(examinationID);

        if (patientDoctorExamination != null) {
            if (patientDoctorExamination.getLabExam() instanceof BloodPressure) {
                BloodPressure bloodPressure = (BloodPressure) patientDoctorExamination.getLabExam();
                bloodPressure.setUpperValue(upperValue);
                bloodPressure.setLowerValue(lowerValue);
                bloodPressure.setPulse(pulse);

                log.info("Examination is successfully done! \n"
                        + "==========\n"
                        + "upper value: " + upperValue +
                        "\nlower value: " + lowerValue +
                        "\npulse: " + pulse);
            } else
                log.info("Selected examination isn't for blood pressure!");
            } else
                log.info("Selected examination doesn't exist!");
    }

}


