package App.service;

import App.dao.PatientDaoSql;
import App.model.Patient;

import java.util.List;
import java.util.Optional;

public class PatientService {
   private PatientDaoSql myPatientDao = new PatientDaoSql();

    public List<Patient> findAll() {
        return this.myPatientDao.findAll();
    }

    public Patient findById(int id) {
        return this.myPatientDao.findById(id).orElseThrow();
    }

    public void addPatient (Patient addedPatient) {

        this.myPatientDao.add(addedPatient);
    }

}
