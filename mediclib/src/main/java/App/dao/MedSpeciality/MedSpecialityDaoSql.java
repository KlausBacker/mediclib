package App.dao.MedSpeciality;

import App.dao.AbstractDaoSql;
import App.model.MedSpeciality;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class MedSpecialityDaoSql extends AbstractDaoSql implements IMedSpecialityDao {

    @Override
    public List<MedSpeciality> findAll() {
        return null;
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
}
