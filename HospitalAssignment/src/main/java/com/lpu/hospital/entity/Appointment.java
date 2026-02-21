package com.lpu.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointDate;
    private String status;
    private String reason;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Appointment() {
    }

    public Appointment(LocalDateTime appointDate, String status, String reason) {
        this.appointDate = appointDate;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(LocalDateTime appointDate) {
        this.appointDate = appointDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointDate=" + appointDate +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}