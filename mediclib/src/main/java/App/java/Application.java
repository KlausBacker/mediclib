package App.java;

import App.dao.AbstractDaoSql;
import App.model.Doctor;
import App.model.Patient;
import App.service.DoctorService;
import App.service.PatientService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");
        daoDoctor();
        daoPatient();
    }

    public static void daoDoctor() {
        DoctorService doctorService = new DoctorService();
        List<Doctor> doctorList = doctorService.findAll();
        for (Doctor d : doctorList) {
            System.out.println(d.getFirstName() + " " + d.getLastName());
        }
    }
        public static void daoPatient () {
            PatientService patientService = new PatientService();
            List<Patient> patientList = patientService.findAll();
            for (Patient p : patientList) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }
    }

