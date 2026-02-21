package com.lpu.hospital.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {
    }

    public Department(String name, String location, String headDoctorName) {
        this.name = name;
        this.location = location;
        this.headDoctorName = headDoctorName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeadDoctorName() {
        return headDoctorName;
    }

    public void setHeadDoctorName(String headDoctorName) {
        this.headDoctorName = headDoctorName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.setDepartment(this);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
        doctor.setDepartment(null);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", headDoctorName='" + headDoctorName + '\'' +
                '}';
    }
}