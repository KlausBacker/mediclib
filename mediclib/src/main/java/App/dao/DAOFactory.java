package App.dao;

import App.dao.Doctor.DoctorDaoHibernate;
import App.dao.Doctor.DoctorDaoSql;
import App.dao.Doctor.IDoctorDao;
import App.dao.MedSpeciality.IMedSpecialityDao;
import App.dao.MedSpeciality.MedSpecialityDaoSql;
import App.dao.MedSpeciality.MedSpecialitydaoHibernate;
import App.dao.Patient.IPatientDao;
import App.dao.Patient.PatientDaoSql;

public class DAOFactory {

    public static IDoctorDao createDoctorDao() {
        return new DoctorDaoHibernate();
    }

    public static IMedSpecialityDao createMedSpecialitydao() {
        return new MedSpecialitydaoHibernate();
    }

    public static IPatientDao createPatientDao() {
        return new PatientDaoSql();
    }
}
