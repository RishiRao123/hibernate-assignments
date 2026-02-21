package com.lpu.hospital.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean isActive;

    public Prescription() {
    }

    public Prescription(String medicines, String dosage, LocalDate issuedDate, boolean isActive) {
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", medicines='" + medicines + '\'' +
                ", dosage='" + dosage + '\'' +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                '}';
    }
}