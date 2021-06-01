package App.java;

import App.dao.AbstractDaoSql;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;
import App.model.MedSpeciality;
import App.model.Patient;
import App.service.DoctorService;
import App.service.MedSpecialityService;
import App.service.PatientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");

        daoMedSpeciality();
        //daoDoctor();
        // daoPatient();
    }

    public static void daoDoctor() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MedicLibUnit");
        EntityManager em = emf.createEntityManager();

        List<Doctor> doctorList = em
                .createQuery("select d from Doctor d", Doctor.class)
                .getResultList();

        for (Doctor d : doctorList) {
            System.out.println("Prenom => " + d.getFirstName() + "\n" + "nom => " + d.getLastName() + "\n" + "secteur => " + d.getSector());

            for (MedSpeciality medspe : d.getSpecialityList()) {
                System.out.println("Spécialité = > " + medspe.getName());
            }
        }

       /* DoctorService doctorService = new DoctorService();
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
        System.out.println("");*/
    }

    public static void daoMedSpeciality() {
        MedSpecialityService medSpecialityService = new MedSpecialityService();
//        READ
        List<MedSpeciality> medSpecialityList =  medSpecialityService.findAll();
        for (MedSpeciality medspe : medSpecialityList) {
            System.out.println(medspe.getName());
            for (Doctor d : medspe.getDoctorList()) {
                System.out.println("Praticiens : " + d.getFirstName() + " " + d.getLastName());
            }
        }
//        CREATE
        MedSpeciality newSpeciality = new MedSpeciality();
        System.out.println("creation nouvelle specialité");
        newSpeciality.setName("Exemplology");
        System.out.println("Nommage de la nouvelle Specialité => " + newSpeciality.getName());
        medSpecialityService.add(newSpeciality);
        System.out.println("Enregistrement de la nouvelle Specialité");
        System.out.println(newSpeciality.getName() + " enregistré à l'ID " + newSpeciality.getId() + "\n" + "INSERT fonctionnel ! ");
//        UPDATE
        int id = newSpeciality.getId();
        System.out.println("recuperation de l'id =>" + newSpeciality.getId());
        MedSpeciality specialityToUpdate = medSpecialityService.findById(id);
        System.out.println("test");
        specialityToUpdate.setName("ModifyName");
        System.out.println("Modification du nom de la Specialité à modifier");
        medSpecialityService.update(specialityToUpdate);
        System.out.println("enregistrement de l'Update");
        System.out.println("Nom changé pour =>" + specialityToUpdate.getName() + "\n" + "UPDATE fonctionnel ! ");
//        DELETE
        if(medSpecialityService.delete(id)){
            System.out.println("Specialité suprimmée");
            System.out.println("DELETE fonctionnel");
        }
        else{
            System.out.println("echec delete");
        }

        System.exit(0);

    }

    public static void daoPatient() {
        PatientService patientService = new PatientService();
        List<Patient> patientList = patientService.findAll();
        for (Patient p : patientList) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
    }


}

