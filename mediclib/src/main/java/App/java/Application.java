package App.java;

import App.dao.AbstractDaoSql;
import App.model.Doctor;
import App.model.Patient;
import App.service.DoctorService;
import App.service.PatientService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        daoDoctor();
//        daoPatient();
//        addPatient();
        updatePatient();

    }
    public static void updatePatient() {
        PatientService patServ = new PatientService();
        Patient patientToUpdate = patServ.findById(1);

        patientToUpdate.setLastName("Foucault");
        patientToUpdate.setFirstName("Jean-Pierre");
        patServ.updatePatient(patientToUpdate);

        Patient patientToUpdate2 = patServ.findById(2);

        patientToUpdate2.setLastName("Dupont");
        patientToUpdate2.setFirstName("Jean-Jacques");
        patServ.updatePatient(patientToUpdate2);

        Patient patientToUpdate3 = patServ.findById(3);
        patientToUpdate3.setLastName("Rodriguez");
        patientToUpdate3.setFirstName("Alberta");
        patServ.updatePatient(patientToUpdate3);

        Patient patientToUpdate4 = patServ.findById(4);
        patientToUpdate4.setLastName("Gerken");
        patientToUpdate4.setFirstName("Jana");
        patServ.updatePatient(patientToUpdate4);

        Patient patientToUpdate5 = patServ.findById(5);
        patientToUpdate5.setLastName("Mbala");
        patientToUpdate5.setFirstName("Arthuro");
        patServ.updatePatient(patientToUpdate5);
    }
    public static void addPatient() {
        PatientService patServ = new PatientService();
        Patient addedPatient = new Patient();

        addedPatient.setFirstName("Anne-Sophie");
        addedPatient.setLastName("Fernandes");
        addedPatient.setNumberSecSoc("2 91 07 22 567 663 26");
        addedPatient.setBirthday(Date.valueOf("1964-06-24"));
        addedPatient.setTel("0664564789");
        addedPatient.setAdd_id(6);

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
    }

