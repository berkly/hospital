package program;

import model.Doctor;
import model.Patient;

import java.util.Date;

public class ProgramHospital {
    public static void main(String[] args) {
        org.apache.log4j.BasicConfigurator.configure();
        Hospital.getInstance().createDoctor("1234", "Bob", "Williams", "surgeon");
        Hospital.getInstance().createPatient("2345", "Fill", "Kane", 25);
        Doctor doctor = Hospital.getInstance().tryGetDoctor("1234");
        Patient patient = Hospital.getInstance().tryGetPatient("2345");

        int examination1 = Hospital.getInstance().scheduleExamination(doctor, patient, new Date(), Hospital.laboratoryExaminations.bloodSugarLevel);
        int examination2 = Hospital.getInstance().scheduleExamination(doctor, patient, new Date(), Hospital.laboratoryExaminations.bloodPressure);

        Hospital.getInstance().FillBloodSugarLevelExamination(examination1,12, new Date());
        Hospital.getInstance().FillBloodPressureExamination(examination2,120, 90, 32);
    }
}
