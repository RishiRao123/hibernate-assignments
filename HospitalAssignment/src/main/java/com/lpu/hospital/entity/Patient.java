package com.lpu.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    private String bloodGroup;
    private String phone;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "med_record_id")
    private MedicalRecord medicalRecord;

    // 🔹 Default constructor (JPA requirement)
    public Patient() {
    }

    // 🔹 Parameterized constructor
    public Patient(String name, LocalDate dob, String bloodGroup, String phone, MedicalRecord medicalRecord) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.medicalRecord = medicalRecord;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    // 🔹 toString()
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}