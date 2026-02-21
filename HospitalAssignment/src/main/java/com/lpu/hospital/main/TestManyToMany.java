package com.lpu.hospital.main;


import com.lpu.hospital.entity.Doctor;
import com.lpu.hospital.entity.Patient;
import com.lpu.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TestManyToMany {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Doctor d1 = new Doctor();
        d1.setName("Dr. Smith");
        d1.setSpecialization("Cardiologist");
        d1.setLicenseNo("LIC500");

        Doctor d2 = new Doctor();
        d2.setName("Dr. Alice");
        d2.setSpecialization("Neurologist");
        d2.setLicenseNo("LIC501");

        Patient p1 = new Patient();
        p1.setName("Varun");
        p1.setBloodGroup("O+");
        p1.setPhone("9999999999");

        Patient p2 = new Patient();
        p2.setName("Rahul");
        p2.setBloodGroup("A+");
        p2.setPhone("8888888888");

        // linking
        d1.addPatient(p1);
        d1.addPatient(p2);
        d2.addPatient(p1);

        em.persist(d1);
        em.persist(d2);

        tx.commit();
        em.close();

        System.out.println("✅ Many-to-Many saved successfully");
    }
}
