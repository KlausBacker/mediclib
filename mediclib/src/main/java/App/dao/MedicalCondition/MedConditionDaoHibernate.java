package App.dao.MedicalCondition;

import App.dao.AbstractDaoHibernate;
import App.model.MedCondition;

import java.util.Optional;

public class MedConditionDaoHibernate extends AbstractDaoHibernate<MedCondition> implements IMedConditionDao {
    public MedConditionDaoHibernate() {
        super(MedCondition.class);
    }

}
