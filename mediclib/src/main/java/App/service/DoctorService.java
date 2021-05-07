package App.service;

import App.dao.DAOFactory;
import App.dao.Doctor.IDoctorDao;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;

import java.util.List;

public class DoctorService {

    private IDoctorDao dao = DAOFactory.createDoctorDao();

    public List<Doctor> findAll() {
        return this.dao.findAll();
    }


    public Doctor findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.dao.findById(id).orElseThrow(null);
    }

}
