package App.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "app_id")
    private int appId;

    @OneToOne
    @JoinColumn(name = "app_doctor_id")
    private Doctor doctor;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDateTime appDate) {
        this.appDate = appDate;
    }

    @OneToOne
    @JoinColumn(name = "app_patient_id")
    private Patient patient;

    @Column(name = "app_date", nullable = false)
    private LocalDateTime appDate;
}
