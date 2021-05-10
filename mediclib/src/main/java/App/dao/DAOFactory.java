package App.dao;

import App.dao.Doctor.DoctorDaoSql;
import App.dao.Doctor.IDoctorDao;
import App.dao.MedSpeciality.IMedSpecialityDao;
import App.dao.MedSpeciality.MedSpecialityDaoSql;

public class DAOFactory {
    public static IDoctorDao createDoctorDao() {
        return new DoctorDaoSql();
    }
    public static IMedSpecialityDao createMedSpecialitydao() {
        return new MedSpecialityDaoSql();
    }

}
