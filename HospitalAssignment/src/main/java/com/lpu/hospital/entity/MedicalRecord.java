package com.lpu.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(nullable = false)
    private String diagnosis;

    @Column(length = 1000)
    private String notes;

    public MedicalRecord() {
    }

    public MedicalRecord(LocalDate recordDate, String diagnosis, String notes) {
        this.recordDate = recordDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", recordDate=" + recordDate +
                ", diagnosis='" + diagnosis + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}