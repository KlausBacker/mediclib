package App.dao.PatientMedicalCondition;

import App.dao.AbstractDaoHibernate;
import App.model.PatMedCondition;

import java.util.Optional;

public class PatMedConDaoHibernate extends AbstractDaoHibernate<PatMedCondition> implements IPatMedCondition{
    public PatMedConDaoHibernate() {
        super(PatMedCondition.class);
    }

}
