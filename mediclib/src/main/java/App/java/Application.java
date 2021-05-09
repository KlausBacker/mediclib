package App.java;

import App.dao.AbstractDaoSql;
import App.model.Doctor;
import App.model.Patient;
import App.service.DoctorService;
import App.service.PatientService;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
//        daoDoctor();
//        daoPatient();
//        addPatient();
        updatePatient();
//        patientFindById();

    }
    public static void updatePatient() {
        PatientService patServ = new PatientService();
        Patient patientToUpdate = patServ.findById(1);
        patServ.updatePatient(patientToUpdate);

    }
    public static void addPatient() {
        PatientService patServ = new PatientService();
        Patient addedPatient = new Patient();
        patServ.addPatient(addedPatient);
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
        public static void patientfindById() {
        PatientService patientService = new PatientService();
        try {
            Patient researchedPatient = patientService.findById(0);
            System.out.println("The searched patient is " + researchedPatient.getFirstName() + " " + researchedPatient.getLastName());
        } catch (NoSuchElementException nsex) {
            System.out.println("The patient with given ID does not exist.");
        }


        }
    }

