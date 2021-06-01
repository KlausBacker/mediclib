package App.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "pat_ID")
    private int id;

    @Column(name = "pat_first_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @Column(name = "pat_last_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @Column(name = "pat_social_sec_number", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String numberSecSoc;

    @Column(name = "pat_birthday", nullable = false)
    @NotBlank
    private java.sql.Date birthday;

    @Column(name = "pat_phone_number", length = 50, nullable = false)
    @NotBlank
    @Size(max=50)
    private String tel;

//    @Column(name = "pat_address_id")
//    private int ad_Id;
//    // a remplacer plus tard par private Address address;

    @ManyToOne
    @JoinColumn(name = "pat_address_id")
    private Address patAddress;
    // a remplacer plus tard par private Address address;

    @OneToMany(mappedBy = "id.patient")
    private List<PatMedCondition> sickPatients;

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

//    public int getAd_Id() {
//        return ad_Id;
//    }
//
//    public void setAd_Id(int ad_Id) {
//        this.ad_Id = ad_Id;
//    }

    public Address getPatAddress() {
        return patAddress;
    }

    public void setPatAddress(Address patAddress) {
        this.patAddress = patAddress;
    }

    public List<PatMedCondition> getSickPatients() {
        return sickPatients;
    }

    public void setSickPatients(List<PatMedCondition> sickPatients) {
        this.sickPatients = sickPatients;
    }
}
