package App.dao;

import App.dao.Doctor.DoctorDaoSql;
import App.dao.Doctor.IDoctorDao;
import App.dao.Patient.IPatientDao;
import App.dao.Patient.PatientDaoSql;
import App.model.Patient;

public class DAOFactory {
    public static IDoctorDao createDoctorDao() {
        return new DoctorDaoSql();
    }
public static IPatientDao createPatientDao() {
        return new PatientDaoSql();
}
}
