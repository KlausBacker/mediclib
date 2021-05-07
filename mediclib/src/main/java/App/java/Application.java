package App.java;

import App.model.Patient;
import App.service.PatientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        PatientService patServ = new PatientService();
//
        List<Patient> allPatients = patServ.findAll();

        for (Patient p : allPatients) {
            System.out.println("Patient number " + p.getId() + " is " + p.getFirstName() + " " + p.getLastName());
        }
        try {
            Patient myPatient = patServ.findById(4);
            System.out.println(myPatient.getFirstName() + "-" + myPatient.getLastName());
        }
        catch (NoSuchElementException nsel) {
            System.out.println("The product with given reference (ID) does not exist.");
        }


    }

}
