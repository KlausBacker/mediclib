package App.dao;

import App.dao.Doctor.DoctorDaoSql;
import App.dao.Doctor.IDoctorDao;

public class DAOFactory {
    public static IDoctorDao createDoctorDao() {
        return new DoctorDaoSql();
    }

}
