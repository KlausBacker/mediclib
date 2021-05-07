package App.dao.Doctor;

import App.dao.AbstractDaoSql;
import App.model.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDaoSql extends AbstractDaoSql implements IDoctorDao {
    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctorList = new ArrayList<>();
        try {
            ResultSet resultSet = this.extractResults("SELECT * FROM Doctor");
            while (resultSet.next()) {
                Doctor doctor = this.map(resultSet);
                doctorList.add(doctor);
            }

        }catch (SQLException sqle) {
            sqle.getCause();
        }
        return doctorList;

    }

    @Override
    public Optional<Doctor> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Doctor add(Doctor entity) {
        return null;
    }

    @Override
    public Doctor update(Doctor entity) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private Doctor map(ResultSet resultSet) {
        try {
            //Récupérer les informations
            int id = resultSet.getInt("doc_id");
            String firstName = resultSet.getString("doc_first_name");
            String lastName = resultSet.getString("doc_last_name");
            int sector = resultSet.getInt("doc_sector");
           // String speciality = resultSet.getString("Medspe_name");

            //Instancier un produit, une catégorie, un fournisseur
            Doctor doctor = new Doctor();
          //  MedSpeciality medSpeciality = new MedSpeciality();

            //Affecter ses informations
            doctor.setId(id);
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            //doctor.setSpeciality(speciality);
            //On retourne le Docteur
            return doctor;
        }catch (SQLException sqle) {
            sqle.printStackTrace(); //TODO : remove..
            return null;
        }
    }

    @Override
    protected ResultSet getResult(String s) {
        return null;
    }
}
