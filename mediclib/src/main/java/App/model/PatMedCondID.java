package App.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PatMedCondID implements Serializable {
    private static  final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "patcon_patient_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "patcon_medcon_ID")
    private MedCondition disease;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedCondition getDisease() {
        return disease;
    }

    public void setDisease(MedCondition disease) {
        this.disease = disease;
    }
}
