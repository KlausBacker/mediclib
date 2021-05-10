package App.model;

public class Patient {
   private int id;
   private String firstName;
   private String lastName;
    private String numberSecSoc;
    private java.sql.Date birthday;
    private String tel;
    private int add_id;
    // a remplacer plus tard par private Address address;

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

    public String getNumberSecSoc() {
        return numberSecSoc;
    }

    public void setNumberSecSoc(String numberSecSoc) {
        this.numberSecSoc = numberSecSoc;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAdd_id() {
        return add_id;
    }

    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }
}
