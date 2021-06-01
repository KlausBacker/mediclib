package App.dao.Patient;

import App.dao.AbstractDaoHibernate;
import App.model.Patient;

import java.util.Optional;
import java.util.Scanner;

public class PatientDaoHibernate extends AbstractDaoHibernate<Patient> implements IPatientDao {
    public PatientDaoHibernate() {
        super(Patient.class);
    }
    Scanner inputPatient = new Scanner(System.in);

    @Override
    public Patient add(Patient entity) {

        boolean everythingFine = false;
        while (!everythingFine) {
            System.out.println("Enter the following data in order to add a new patient: ");
            System.out.println("Warning! Address database has to be filled first! ");
            System.out.println("Last name ");
            String lastName = inputPatient.nextLine();
            entity.setLastName(lastName);
            System.out.println("First name ");
            entity.setFirstName(inputPatient.nextLine());
            System.out.println("Security number ");
            entity.setNumberSecSoc(inputPatient.nextLine());
            System.out.println("Birthdate (input format: yyyy-mm-dd)");
            entity.setBirthday(java.sql.Date.valueOf(inputPatient.nextLine()));
            System.out.println("Phone number ");
            entity.setTel(inputPatient.nextLine());
            System.out.println("Address ID ");
            entity.setAd_Id(inputPatient.nextInt());
            System.out.println();
            everythingFine = true;
        }
//        add(entity);
        return super.add(entity);
    }
}
