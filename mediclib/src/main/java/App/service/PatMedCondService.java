package App.service;

import App.dao.DAOFactory;
import App.dao.PatientMedicalCondition.IPatMedCondition;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;
import App.model.PatMedCondition;

import java.util.List;

public class PatMedCondService {
    private IPatMedCondition patMedConDao = DAOFactory.createPatMedConditionDao();

    public List<PatMedCondition> findAll() {
        return this.patMedConDao.findAll();
    }
    public PatMedCondition findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.patMedConDao.findById(id).orElseThrow(null);
    }
    public void add(PatMedCondition newDisease) {
        this.patMedConDao.add(newDisease);
    }
    public void update(PatMedCondition upDisease) {
        this.patMedConDao.update(upDisease);
    }
    public void deleteById(int id) {
        this.patMedConDao.deleteById(id);
    }
}
