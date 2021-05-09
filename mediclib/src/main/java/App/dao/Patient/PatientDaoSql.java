package App.dao.Patient;

import App.dao.AbstractDaoSql;
import App.model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PatientDaoSql extends AbstractDaoSql implements IPatientDao {
    Scanner inputPatient = new Scanner(System.in);

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
    public ArrayList<Integer> findAllId() {
        ArrayList<Integer> allIDS = new ArrayList<>();

        try {
            ResultSet myResults = this.extractResults("SELECT * FROM Patient");

            while(myResults.next()) {
                int foundID = myResults.getInt("pat_id");
                allIDS.add(foundID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allIDS;
    }

    @Override
    public Optional<Patient> findById(int id) {
        try {
            System.out.println("Please enter the ID of searched patient. ");
            boolean hasNextInt = inputPatient.hasNextInt();
            id = inputPatient.nextInt();


            if(hasNextInt) {
                ArrayList<Integer> allIds =  findAllId();
                if (!allIds.contains(id)) {
                    System.out.println("The patient with given ID does not exist");
                    System.out.println("Enter a new ID: ");
                    id = inputPatient.nextInt();
                }
            }
            else {
                System.out.println("Inavlid ID - the input is not a number. ");
            }

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

        System.out.println("Enter the following data in order to add a new patient: ");
        System.out.println("Warning! Address database has to be filled first! ");
        System.out.println("Last name ");
        String lastName = inputPatient.nextLine();
        entity.setLastName(lastName);
        System.out.println("First name ");
        entity.setFirstName(inputPatient.nextLine());
        System.out.println("Security number ");
        entity.setNumberSecSoc(inputPatient.nextLine());
        System.out.println("Birthdate (input format: yyyy-mm-dd)");
        entity.setBirthday(java.sql.Date.valueOf(inputPatient.nextLine()));
        System.out.println("Phone number ");
        entity.setTel(inputPatient.nextLine());
        System.out.println("Address ID ");
        entity.setAdd_id(inputPatient.nextInt());

//        addQuery
//                .append("INSERTO INTO Patient ")
//                .append("(pat_id, pat_last_name, pat_first_name, ")
//                .append(" pat_social_sec_number, pat_birthday, pat_phone_number,")
//                .append("pat_address_id) VALUES (?,?,?,?,?,?)");

        System.out.println();

        this
//                .prepare(addQuery.toString())
                .prepare("INSERT INTO Patient " + "(pat_last_name, pat_first_name, "
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
        StringBuilder updateQuery = new StringBuilder();

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("Enter the parameter to update or press 7 to exit. ");
            choice = inputPatient.nextInt();
            inputPatient.nextLine();

            switch(choice) {
                case 0:
                    findById(0);
                    break;
                case 1:
                    System.out.println("Enter new last name: ");
                    entity.setLastName(inputPatient.nextLine());
                    break;
                case 2:
                    System.out.println("Enter new first name: ");
                    entity.setFirstName(inputPatient.nextLine());
                    break;
                case 3:
                    System.out.println("Enter new social security number: ");
                    entity.setNumberSecSoc(inputPatient.nextLine());
                    break;
                case 4:
                    System.out.println("Enter new birthdate (input format: yyyy-mm-dd) ");
                    entity.setBirthday(java.sql.Date.valueOf(inputPatient.nextLine()));
                    break;
                case 5:
                    System.out.println("Enter new phone number ");
                    entity.setTel(inputPatient.nextLine());
                    break;
                case 6:
                    System.out.println("Enter new address_id");
                    entity.setAdd_id(inputPatient.nextInt());
                    inputPatient.nextLine();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }


        updateQuery
                .append("UPDATE Patient SET Pat_last_name = ?, ")
                .append(" Pat_first_name = ?, ")
                .append(" pat_social_sec_number = ?, ")
                .append(" pat_birthday = ?, ")
                .append(" pat_phone_number = ?, ")
                .append(" pat_address_id = ? ")
                .append(" where pat_id = ? ");

        this
                .prepare(updateQuery.toString())
                .setParameter(entity.getLastName())
                .setParameter(entity.getFirstName())
                .setParameter(entity.getNumberSecSoc())
                .setParameter(entity.getBirthday())
                .setParameter(entity.getTel())
                .setParameter(entity.getAdd_id())
                .setParameter(entity.getId())
                .execute();

        return entity;
    }
    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To find a patient by its ID.");
        System.out.println("\t 1 - To modify the last name.");
        System.out.println("\t 2 - To To modify the first name.");
        System.out.println("\t 3 - To modify the social security number");
        System.out.println("\t 4 - To modify the birthdate");
        System.out.println("\t 5 - To modify the phone number");
        System.out.println("\t 6 - To modify the address ID");
        System.out.println("\t 7 - To quit the application.");
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
            java.sql.Date birthdate = myResults.getDate("pat_birthday");
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
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
