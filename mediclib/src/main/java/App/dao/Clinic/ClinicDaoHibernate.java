package App.dao.Clinic;

import App.dao.AbstractDaoHibernate;
import App.model.Clinic;

import java.util.Optional;

public class ClinicDaoHibernate extends AbstractDaoHibernate<Clinic> implements IClinicDao {
    public ClinicDaoHibernate() {
        super(Clinic.class);
    }


}
