package App.dao.MedSpeciality;

import App.dao.AbstractDaoSql;
import App.model.Doctor;
import App.model.MedSpeciality;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedSpecialityDaoSql extends AbstractDaoSql implements IMedSpecialityDao {

    @Override
    public List<MedSpeciality> findAll() {


        List<MedSpeciality> MedSpeList = new ArrayList<>();
        try {
            ResultSet resultSet = this.extractResults("SELECT * FROM Med_speciality");
            while (resultSet.next()) {
                MedSpeciality medSpe = this.map(resultSet);
                MedSpeList.add(medSpe);
            }

        }catch (SQLException sqle) {
            sqle.getCause();
        }
        return MedSpeList;

    }

    @Override
    public Optional<MedSpeciality> findById(int id) {
        return Optional.empty();
    }

    @Override
    public MedSpeciality add(MedSpeciality entity) {
        return null;
    }

    @Override
    public MedSpeciality update(MedSpeciality entity) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private MedSpeciality map(ResultSet resultSet) {
        try {
            //Récupérer les informations
            int id = resultSet.getInt("Medspe_id");
            String firstName = resultSet.getString("Medspe_name");

            //Instancier Medical speciality
            MedSpeciality medSpe = new MedSpeciality();

            //Affecter ses informations
            medSpe.setId(id);
            medSpe.setName(firstName);

            return medSpe;
        }catch (SQLException sqle) {
            sqle.printStackTrace(); //TODO : remove..
            return null;
        }
    }
}
