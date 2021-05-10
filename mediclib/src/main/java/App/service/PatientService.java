package App.service;

import App.dao.DAOFactory;
import App.dao.Patient.IPatientDao;
import App.dao.Patient.PatientDaoSql;
import App.model.Patient;

import java.util.List;

public class PatientService {
   private IPatientDao myPatientDao = DAOFactory.createPatientDao();

    public List<Patient> findAll() {
        return this.myPatientDao.findAll();
    }

    public Patient findById(int id) {
        return this.myPatientDao.findById(id).orElseThrow(null);
    }

    public void addPatient (Patient addedPatient) {

        this.myPatientDao.add(addedPatient);
    }
    public void updatePatient (Patient updatedPatient) {

        this.myPatientDao.update(updatedPatient);
    }

}
