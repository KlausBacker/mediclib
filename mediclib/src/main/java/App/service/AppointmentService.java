package App.service;

import App.dao.Appointment.IAppointmentDao;
import App.dao.DAOFactory;
import App.exception.IdMustBePositiveException;
import App.model.Appointment;
import App.model.Doctor;

import java.util.List;

public class AppointmentService {
    private IAppointmentDao appDao = DAOFactory.createAppointmentDao();

    public List<Appointment> findAll() {
        return this.appDao.findAll();
    }
    public Appointment findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.appDao.findById(id).orElseThrow(null);
    }
    public void add(Appointment appointment) {
        this.appDao.add(appointment);
    }
    public void update(Appointment appointment) {
        this.appDao.update(appointment);
    }
    public void deleteById(int id) {
        this.appDao.deleteById(id);
    }
}
