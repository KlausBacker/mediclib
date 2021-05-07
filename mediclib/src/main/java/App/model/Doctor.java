package App.model;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private MedSpeciality speciality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MedSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedSpeciality speciality) {
        this.speciality = speciality;
    }
}
