package model;


public class PatientDoctorExamination {
    private Doctor doctor;
    private Patient patient;
    private LaboratoryExamination labExam;

    public PatientDoctorExamination(Doctor doctor, Patient patient, LaboratoryExamination labExam) {
        this.doctor = doctor;
        this.patient = patient;
        this.labExam = labExam;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LaboratoryExamination getLabExam() {
        return labExam;
    }

    public void setLabExam(LaboratoryExamination labExam) {
        this.labExam = labExam;
    }
}
