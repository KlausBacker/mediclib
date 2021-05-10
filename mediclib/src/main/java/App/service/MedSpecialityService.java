package App.service;

import App.dao.DAOFactory;
import App.dao.Doctor.IDoctorDao;
import App.dao.MedSpeciality.IMedSpecialityDao;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;
import App.model.MedSpeciality;

import java.util.List;

public class MedSpecialityService {

    private IMedSpecialityDao dao = DAOFactory.createMedSpecialitydao();

    public List<MedSpeciality> findAll() {
        return this.dao.findAll();
    }


    public MedSpeciality findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.dao.findById(id).orElseThrow(null);
    }

}
