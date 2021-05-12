package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Doctor")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private int id;

    @Column(name = "doc_last_name", length = 100, nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "doc_first_name", length = 100, nullable = false)
    @NotBlank
    private String lastName;


    @ManyToMany
    @JoinTable(
            name = "Doctor_speciality",
            /*TABLE Doctor*/
            joinColumns = @JoinColumn(name = "docspe_doctor_id", referencedColumnName = "doc_id"),
            /*TABLE Med_speciality */
            inverseJoinColumns = @JoinColumn(name = "docspe_speciality_id", referencedColumnName = "Medspe_id")
    )
    private List<MedSpeciality> specialityList;

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

    public List<MedSpeciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<MedSpeciality> specialityList) {
        this.specialityList = specialityList;
    }
}
