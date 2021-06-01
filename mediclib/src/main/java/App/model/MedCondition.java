package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "med_condition")
public class MedCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "medco_id")
    private int condId;

    @Column(name = "medco_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "medco_med_specialty_id")
    private MedSpeciality speciality;

    @OneToMany(mappedBy = "id.disease")
    private List<PatMedCondition> sickPatients;

    public int getCondId() {
        return condId;
    }

    public void setCondId(int condId) {
        this.condId = condId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedSpeciality speciality) {
        this.speciality = speciality;
    }

    public List<PatMedCondition> getSickPatients() {
        return sickPatients;
    }

    public void setSickPatients(List<PatMedCondition> sickPatients) {
        this.sickPatients = sickPatients;
    }
}
