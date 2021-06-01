package App.service;

import App.dao.DAOFactory;
import App.dao.MedicalCondition.IMedConditionDao;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;
import App.model.MedCondition;

import java.util.List;

public class MedConditionService {
    private IMedConditionDao medConDao = DAOFactory.createMedConditionDao();

    public List<MedCondition> findAll() {
        return this.medConDao.findAll();
    }
    public MedCondition findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.medConDao.findById(id).orElseThrow(null);
    }
    public void add(MedCondition medCondition) {
        this.medConDao.add(medCondition);
    }
    public void update(MedCondition medCondition) {
        this.medConDao.update(medCondition);
    }
    public void deleteById(int id) {
        this.medConDao.deleteById(id);
    }
}
