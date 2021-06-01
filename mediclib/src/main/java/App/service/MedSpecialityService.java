package App.service;

import App.dao.DAOFactory;
import App.dao.MedSpeciality.IMedSpecialityDao;
import App.exception.IdMustBePositiveException;
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
    public void add(MedSpeciality medspe) {

        this.dao.add(medspe);
    }

    public void update(MedSpeciality medspe) {

        this.dao.update(medspe);
    }
    public boolean delete(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }
        this.dao.deleteById(id);
        return false;
    }

}
