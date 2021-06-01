package App.dao.Appointment;

import App.dao.AbstractDaoHibernate;
import App.model.Appointment;

import java.util.Optional;

public class AppointmentDaoHibernate extends AbstractDaoHibernate<Appointment> implements IAppointmentDao{

    public AppointmentDaoHibernate() {
        super(Appointment.class);
    }

}
