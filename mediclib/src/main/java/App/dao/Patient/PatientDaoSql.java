package App.dao.Patient;

import App.dao.AbstractDaoSql;
import App.dao.Patient.IPatientDao;
import App.model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PatientDaoSql extends AbstractDaoSql implements IPatientDao {

    @Override
    public List<Patient> findAll() {
        List<Patient> allPatients = new ArrayList<>();

        try {
            ResultSet myResults = this.extractResults("SELECT * FROM Patient");

            while(myResults.next()) {
                Patient myPatient = this.patMap(myResults);
                allPatients.add(myPatient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allPatients;
    }

    @Override
    public Optional<Patient> findById(int id) {
        try {
            ResultSet myResults = this.extractResults("SELECT * FROM Patient WHERE PAT_ID= "  + id);

            if(myResults.next()) {
                Patient mySearchedPatient = this.patMap(myResults);

                return Optional.of(mySearchedPatient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Patient add(Patient entity) {

        StringBuilder addQuery = new StringBuilder();

//        addQuery
//                .append("INSERTO INTO Patient ")
//                .append("(pat_id, pat_last_name, pat_first_name, ")
//                .append(" pat_social_sec_number, pat_birthday, pat_phone_number,")
//                .append("pat_address_id) VALUES (?,?,?,?,?,?)");

        this
//                .prepare(addQuery.toString())
                .prepare("INSERT INTO Patient " + "(pat_id, pat_last_name, pat_first_name, "
                        + "pat_social_sec_number, pat_birthday, pat_phone_number,"
                        + "pat_address_id) VALUES (?,?,?,?,?,?)")
                .setParameter(entity.getLastName())
                .setParameter(entity.getFirstName())
                .setParameter(entity.getNumberSecSoc())
                .setParameter(entity.getBirthday())
                .setParameter(entity.getTel())
                .setParameter(entity.getAdd_id())
                .execute();

        return entity;
    }

    @Override
    public Patient update(Patient entity) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private Patient patMap(ResultSet myResults) {
        try {
            //Extraction of patient data
            int id = myResults.getInt("pat_ID");
            String lastName = myResults.getString("pat_last_name");
            String firstName = myResults.getString("pat_first_name");
            String secNumber = myResults.getString("pat_social_sec_number");
            Date birthdate = myResults.getDate("pat_birthday");
            String phoneNumber = myResults.getString("pat_phone_number");
            int address_id = myResults.getInt("pat_address_id");
            // Address pat_address = resultSet.getAddress("pat_address_id");

//            String numberSecSoc = resultSet.getString("pat_social_sec_number");
//            Date birthday = resultSet.getDate("pat_birthday");
//            String tel = resultSet.getString("pat_phone_number");

            //Creation of new Patient
            Patient myPatient = new Patient();

            //Attribution of patient data
            myPatient.setId(id);
            myPatient.setLastName(lastName);
            myPatient.setFirstName(firstName);
            myPatient.setNumberSecSoc(secNumber);
            myPatient.setBirthday(birthdate);
            myPatient.setTel(phoneNumber);
            myPatient.setAdd_id(address_id);
            //myPatient.setAdd_id(spat_address);

            return myPatient;

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    protected ResultSet getResult(String s) {
        return null;
    }
}
