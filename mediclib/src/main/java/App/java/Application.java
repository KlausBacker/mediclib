package App.java;

import App.dao.AbstractDaoSql;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;
import App.model.Patient;
import App.service.DoctorService;
import App.service.PatientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");

        daoDoctor();
       // daoPatient();
    }

    public static void daoDoctor() {
        DoctorService doctorService = new DoctorService();
        List<Doctor> doctorList = doctorService.findAll();
        for (Doctor d : doctorList) {
            System.out.println(d.getFirstName() + " " + d.getLastName());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(" Quelle est l'ID du docteur recherché ?");
        int id =sc.nextInt();
        System.out.println("Merci !");
        try {
            Doctor doc = doctorService.findById(id);
            System.out.println(doc.getFirstName() + " " + doc.getLastName()+" id ->"+ doc.getId());
        }
        catch (IdMustBePositiveException idex) {
            System.out.println("L'ID doit être superieur à zero !");
        }
        catch (NoSuchElementException nex) {
            System.out.println("Aucun docteur liés à cet ID ");
        }
        System.out.println("");
    }


        public static void daoPatient () {
            PatientService patientService = new PatientService();
            List<Patient> patientList = patientService.findAll();
            for (Patient p : patientList) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }

        public static void daoMedSpeciality(){

        }
    }

