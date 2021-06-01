package App.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patient_med_condition")
public class PatMedCondition {

    @EmbeddedId
    private PatMedCondID id;

    @Column(name = "patcon_detection_date", nullable = false)
    private LocalDate detectionDate;

    public PatMedCondID getId() {
        return id;
    }

    public void setId(PatMedCondID id) {
        this.id = id;
    }

    public LocalDate getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(LocalDate detectionDate) {
        this.detectionDate = detectionDate;
    }
}
