package App.service;

import App.dao.Clinic.IClinicDao;
import App.dao.DAOFactory;
import App.exception.IdMustBePositiveException;
import App.model.Clinic;
import App.model.Doctor;

import java.util.List;

public class ClinicService {
    private IClinicDao cliDao = DAOFactory.createClinicDao();

    public List<Clinic> findAll() {
        return this.cliDao.findAll();
    }
    public Clinic findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.cliDao.findById(id).orElseThrow(null);
    }
    public void add(Clinic newClinic) {
        this.cliDao.add(newClinic);
    }
    public void update(Clinic upClinic) {
        this.cliDao.update(upClinic);
    }
    public void deleteById(int id) {
        this.cliDao.deleteById(id);
    }
}
