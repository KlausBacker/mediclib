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



}
