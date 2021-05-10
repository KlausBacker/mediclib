package App.service;

import App.dao.Patient.PatientDaoSql;
import App.model.Patient;

import java.util.List;

public class PatientService {
   private PatientDaoSql myPatientDao = new PatientDaoSql();

    public List<Patient> findAll() {
        return this.myPatientDao.findAll();
    }

    public Patient findById(int id) {
        return this.myPatientDao.findById(id).orElseThrow(null);
    }

    public void addPatient (Patient addedPatient) {

        this.myPatientDao.add(addedPatient);
    }

}
