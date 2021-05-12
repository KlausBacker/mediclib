package App.dao.Doctor;

import App.dao.AbstractDaoHibernate;
import App.model.Doctor;

public class DoctorDaoHibernate extends AbstractDaoHibernate<Doctor> implements IDoctorDao {
    public DoctorDaoHibernate() {
        super(Doctor.class);
    }
}
