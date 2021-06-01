package App.dao;

import App.dao.Appointment.AppointmentDaoHibernate;
import App.dao.Appointment.IAppointmentDao;
import App.dao.Clinic.ClinicDaoHibernate;
import App.dao.Clinic.IClinicDao;
import App.dao.Doctor.DoctorDaoHibernate;
import App.dao.Doctor.DoctorDaoSql;
import App.dao.Doctor.IDoctorDao;
import App.dao.MedSpeciality.IMedSpecialityDao;
import App.dao.MedSpeciality.MedSpecialityDaoSql;
import App.dao.MedSpeciality.MedSpecialitydaoHibernate;
import App.dao.MedicalCondition.IMedConditionDao;
import App.dao.MedicalCondition.MedConditionDaoHibernate;
import App.dao.Patient.IPatientDao;
import App.dao.Patient.PatientDaoHibernate;
import App.dao.Patient.PatientDaoSql;
import App.dao.PatientMedicalCondition.IPatMedCondition;
import App.dao.PatientMedicalCondition.PatMedConDaoHibernate;

public class DAOFactory {

    public static IDoctorDao createDoctorDao() {
        return new DoctorDaoHibernate();
    }

    public static IMedSpecialityDao createMedSpecialitydao() {
        return new MedSpecialitydaoHibernate();
    }

    public static IPatientDao createPatientDao() {
        return new PatientDaoHibernate();
    }
    public static IAppointmentDao createAppointmentDao() {
        return new AppointmentDaoHibernate();
    }
    public static IClinicDao createClinicDao() {
        return new ClinicDaoHibernate();
    }
    public static IMedConditionDao createMedConditionDao() {
        return new MedConditionDaoHibernate();
    }
    public static IPatMedCondition createPatMedConditionDao() {
        return new PatMedConDaoHibernate();
    }

}
